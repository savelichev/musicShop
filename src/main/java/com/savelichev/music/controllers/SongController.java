package com.savelichev.music.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.savelichev.music.DAOInterfaces.SongDAO;
import com.savelichev.music.model.Song;

@Controller
public class SongController {

	@Autowired
	private SongDAO songDAO;

	@RequestMapping(value = "/listSong", method = RequestMethod.GET)
	public ModelAndView listSong(ModelAndView model) {
		List<Song> listSong = songDAO.list();
		model.addObject("listSong", listSong);
		model.setViewName("listAllSongs");

		return model;
	}

	@RequestMapping(value = "/newSong", method = RequestMethod.GET)
	public ModelAndView newSong(ModelAndView model) {
		Song newSong = new Song();
		model.addObject("song", newSong);
		model.setViewName("SongEditOrAddForm");
		return model;
	}

	@RequestMapping(value = "/saveSong", method = RequestMethod.POST)
	public ModelAndView saveSong(@ModelAttribute Song song) {
		songDAO.saveOrUpdate(song);
		return new ModelAndView("redirect:/listSong");
	}

	@RequestMapping(value = "/deleteSong", method = RequestMethod.GET)
	public ModelAndView deleteSong(HttpServletRequest request) {
		int songId = Integer.parseInt(request.getParameter("id"));
		songDAO.delete(songId);
		return new ModelAndView("redirect:/listSong");
	}

	@RequestMapping(value = "/editSong", method = RequestMethod.GET)
	public ModelAndView editSong(HttpServletRequest request) {
		int songId = Integer.parseInt(request.getParameter("id"));
		Song song = songDAO.getSingleSong(songId);
		ModelAndView model = new ModelAndView("SongEditOrAddForm");
		model.addObject("song", song);

		return model;
	}
}
