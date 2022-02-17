package com.App.Choppin.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.App.Choppin.Repository.FeatureRepository;
import com.App.Choppin.models.Feature;

@Controller
public class FeatureController {
	
	String mensagem;
	
	@Autowired
	private FeatureRepository fr;
	
	// Valida se o usuário já existe
	@RequestMapping("/validaFeature")
	public String validarFeature() {
		long id = 1;
		if (!fr.existsById(id)) {
		return "redirect:/cadastrarFeature";
		} else {
			return "redirect:/atualizarFeature";			
		}
	}
	
	// GET que chama o form para cadastrar feature
	@RequestMapping("/cadastrarFeature")
	public String form() {
		return "Feature/formCadastro";
	}
	// POST que cadastra Feature
	@RequestMapping(value = "/cadastrarFeature", method = RequestMethod.POST)
	public String form(@Valid Feature feature, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarFeature";
		}

		fr.save(feature);
		attributes.addFlashAttribute("mensagem", "Perfil cadastrado com sucesso!");
		return "redirect:/cadastrarFeature";
	}
	// Métodos que atualizam pessoas
	// GET que chama o FORM de edição da pessoa
	@RequestMapping("/atualizarFeature")
	public ModelAndView editarFeature(long id) {
		Feature feature = fr.findById(id);
		ModelAndView mv = new ModelAndView("Feature/formAtualiza");
		mv.addObject("feature", feature);
		mv.addObject("mensagem", mensagem);
		return mv;
	}
	
	// POST que atualiza a Feature
	@RequestMapping(value = "/atualizarFeature", method = RequestMethod.POST)
	public String updateFeature(@Valid Feature feature,  BindingResult result, RedirectAttributes attributes){
		
		fr.save(feature);
		attributes.addFlashAttribute("success", "Perfil alterado com sucesso!");

		return "redirect:/";
	}
}
