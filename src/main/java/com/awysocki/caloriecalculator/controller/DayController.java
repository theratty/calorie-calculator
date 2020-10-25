package com.awysocki.caloriecalculator.controller;

import com.awysocki.caloriecalculator.entity.Day;
import com.awysocki.caloriecalculator.entity.DayIngredient;
import com.awysocki.caloriecalculator.entity.Ingredient;
import com.awysocki.caloriecalculator.entity.User;
import com.awysocki.caloriecalculator.service.DayIngredientService;
import com.awysocki.caloriecalculator.service.DayService;
import com.awysocki.caloriecalculator.service.IngredientService;
import com.awysocki.caloriecalculator.service.UserService;
import com.awysocki.caloriecalculator.wrappers.DayWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

/**
 * This controller is used for day operations.
 * Access to this actions is authorised in SpringSecurity config class.
 */
@Controller
@RequestMapping("/day")
public class DayController {

	@Autowired
	private UserService userService;

	@Autowired
	private DayService dayService;

	@Autowired
	private IngredientService ingredientService;

	@Autowired
	private DayIngredientService dayIngredientService;

	@GetMapping("/add")
	public String showAddDayForm(Model model) {

		model.addAttribute("day", new Day());

		return "add-day-form";
	}

	@GetMapping("/list")
	public String listDays(Principal principal,
			Model model) {

		User currentUser = userService.findByUserName(principal.getName());

		List<Day> days = currentUser.getDays();

		model.addAttribute("days", days);

		return "list-days";
	}

	@GetMapping("/search")
	public String searchDays(@RequestParam("name") String dayName,
							 Principal principal,
							 Model model) {

		User currentUser = userService.findByUserName(principal.getName());
		List<Day> days = currentUser.getDays();

		List<Day> filteredDays = new LinkedList<>();

		for (Day day : days) {
			if (day.getDescription().toLowerCase().contains(dayName.toLowerCase())) {
				filteredDays.add(day);
			}
		}

		model.addAttribute("days", filteredDays);

		return "list-days";
	}

	@PostMapping("/saveDay")
	public String saveDay(@ModelAttribute("day") Day day,
						  Principal principal) {
		User currentUser = userService.findByUserName(principal.getName());

		List<Day> days = currentUser.getDays();
		days.add(day);

		currentUser.setDays(days);

		userService.save(currentUser);

		return "redirect:/day/list";
	}

	@GetMapping("/delete")
	public String deleteDay(@RequestParam("dayId") int dayId) {

		dayService.deleteDay(dayService.findDayById(dayId));

		return "redirect:/day/list";
	}

	@GetMapping("/modify")
	public String modifyDay(@RequestParam("dayId") int dayId,
							Model model) {

		Day day = dayService.findDayById(dayId);
		DayWrapper dayWrapper = new DayWrapper(day);

		model.addAttribute("day", dayWrapper);

		return "modify-day";
	}

	@GetMapping("/addProductToDay")
	public String addProductToDay(@RequestParam("dayId") int dayId,
								  RedirectAttributes redirectAttributes) {

		redirectAttributes.addAttribute("dayId", dayId);
		redirectAttributes.addAttribute("name", "");

		return "redirect:/ingredient/search";
	}

	@GetMapping("/appendIngredient")
	public String showAppendIngredient(@RequestParam("dayId") int dayId,
									   @RequestParam("ingredientId") int ingredientId,
									   Model model) {

		model.addAttribute("dayId", dayId);
		model.addAttribute("ingredientId", ingredientId);

		return "append-ingredient";
	}

	@PostMapping("/saveDayIngredient")
	public String saveDayIngredient(@RequestParam("dayId") int dayId,
									@RequestParam("ingredientId") int ingredientId,
									@RequestParam("amount") int amount,
									RedirectAttributes redirectAttributes) {

		Ingredient ingredient = ingredientService.findById(ingredientId);
		Day day = dayService.findDayById(dayId);

		DayIngredient dayIngredient = new DayIngredient();
		dayIngredient.setIngredient(ingredient);
		dayIngredient.setAmount(amount);

		List<DayIngredient> dayIngredients = day.getDayIngredients();
		dayIngredients.add(dayIngredient);

		day.setDayIngredients(dayIngredients);

		dayService.save(day);

		redirectAttributes.addAttribute("dayId", dayId);

		return "redirect:/day/modify";
	}

	@GetMapping("/deleteIngredient")
	public String deleteIngredient(@RequestParam("dayIngredientId") int dayIngredientId,
								   @RequestParam("dayId") int dayId,
								   RedirectAttributes redirectAttributes) {

		DayIngredient dayIngredientToDelete =
				dayIngredientService.findDayIngredientById(dayIngredientId);

		dayIngredientService.deleteDayIngredient(dayIngredientToDelete);

		redirectAttributes.addAttribute("dayId", dayId);

		return "redirect:/day/modify";
	}

}
