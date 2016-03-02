package com.savelichev.music.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.savelichev.music.DAOInterfaces.BandDAO;
import com.savelichev.music.model.Band;

@Controller
public class BandController {

	@Autowired
	private BandDAO BandDAO;

	@RequestMapping(value = "/listBand", method = RequestMethod.GET)
	public ModelAndView listBand(ModelAndView model) {
		List<Band> listBand = BandDAO.list();
		model.addObject("listBand", listBand);
		model.setViewName("listAllBands");
		return model;

	}

	@RequestMapping(value = "/newBand", method = RequestMethod.GET)
	public ModelAndView newBand(ModelAndView model) {

		Band newBand = new Band();
		model.addObject("band", newBand);
		model.setViewName("BandEditOrAddForm");
		return model;

	}

	@RequestMapping(value = "/saveBand", method = RequestMethod.POST)
	public ModelAndView saveBand(@ModelAttribute Band band) {

		BandDAO.saveOrUpdate(band);

		return new ModelAndView("redirect:/listBand");
	}

	@RequestMapping(value = "/deleteBand", method = RequestMethod.GET)
	public ModelAndView deleteBand(HttpServletRequest request) {
		int bandId = Integer.parseInt(request.getParameter("id"));
		BandDAO.delete(bandId);
		return new ModelAndView("redirect:/listBand");
	}

	@RequestMapping(value = "/editBand", method = RequestMethod.GET)
	public ModelAndView editBand(HttpServletRequest request) {
		int bandId = Integer.parseInt(request.getParameter("id"));
		Band band = BandDAO.getSingleBand(bandId);
		ModelAndView model = new ModelAndView("BandEditOrAddForm");
		model.addObject("band", band);

		return model;
	}
}
