package com.awysocki.caloriecalculator.controller;

import com.awysocki.caloriecalculator.entity.Ingredient;
import com.awysocki.caloriecalculator.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This controller is used for ingredient operations.
 * Some of actions are authorised in Spring Security configuration class.
 */
@Controller
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@GetMapping("/list")
	public String listIngredients(Model model) {

		List<Ingredient> ingredients = ingredientService.findAll();

		model.addAttribute("ingredients", ingredients);

		return "list-ingredients";
	}

	@GetMapping("/search")
	public String searchIngredients(
			@RequestParam("name") String name,
			HttpServletRequest request,
			Model model) {

		List<Ingredient> ingredients = ingredientService.findByName(name);

		String dayIdString = request.getParameter("dayId");

		if (dayIdString != null) {
			int dayId = Integer.parseInt(dayIdString);
			model.addAttribute("dayId", dayId);
		}

		model.addAttribute("ingredients", ingredients);

		return "list-ingredients";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {

		model.addAttribute("ingredient", new Ingredient());

		return "add-form";
	}

	@PostMapping("/saveIngredient")
	public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {

		ingredientService.saveIngredient(ingredient);

		return "redirect:/ingredient/list";

	}
}










