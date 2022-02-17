package com.App.Choppin.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.App.Choppin.Repository.PessoaRepository;
import com.App.Choppin.models.Pessoa;



@Controller
public class PessoaController {

	@Autowired
	private PessoaRepository pr;
	
	String mensagem;
	
	// GET que lista pessoas
	@RequestMapping("/pessoas")
	public ModelAndView listaPessoas() {
		ModelAndView mv = new ModelAndView("Pessoa/formLista");
		Iterable<Pessoa> pessoas = pr.findAll();
		mv.addObject("mensagem", mensagem);
		mv.addObject("pessoas", pessoas);
		return mv;
	}
	
	// GET que chama o form para cadastrar pessoas
	@RequestMapping("/cadastrarPessoa")
	public String form() {
		return "Pessoa/formCadastro";
	}

	// POST que cadastra Pessoas
	@RequestMapping(value = "/cadastrarPessoa", method = RequestMethod.POST)
	public String form(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarPessoa";
		}

		pr.save(pessoa);
		attributes.addFlashAttribute("mensagem", "Pessoa cadastrada com sucesso!");
		return "redirect:/cadastrarPessoa";
	}

	
	//GET que deleta pessoa
	@RequestMapping("/deletarPessoa")
	public String deletarPessoa(long id) {
		Pessoa pessoa = pr.findById(id);
		pr.delete(pessoa);
		return "redirect:/pessoas";	
	}
	
	// Métodos que atualizam pessoas
	// GET que chama o FORM de edição da pessoa
	@RequestMapping("/editarPessoa")
	public ModelAndView editarPessoa(long id) {
		Pessoa pessoa = pr.findById(id);
		ModelAndView mv = new ModelAndView("Pessoa/formAtualiza");
		mv.addObject("pessoa", pessoa);
		mv.addObject("mensagem", mensagem);
		return mv;
	}
	
	// POST que atualiza a pessoa
	@RequestMapping(value = "/editarPessoa", method = RequestMethod.POST)
	public String updatePessoa(@Valid Pessoa pessoa,  BindingResult result, RedirectAttributes attributes){
		
		pr.save(pessoa);
		attributes.addFlashAttribute("success", "Pessoa alterada com sucesso!");

		return "redirect:/pessoas";
	}
}
