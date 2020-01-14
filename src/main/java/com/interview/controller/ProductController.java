package com.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.interview.model.Product;
import com.interview.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/add")
	public String addProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/product/eproductDetails";

	}

	@RequestMapping("/productList")
	public String productList(Model model) {
		List<Product> products = productService.findAll();
		if (products == null) {
			model.addAttribute("emptyList", true);
		}
		model.addAttribute("products", products);
		return "productList";
	}

	@RequestMapping("/eproductDetails")
	public String allProductDetails(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "allProductDetail";
	}

	@RequestMapping("/eproductUpdate")
	public String updateProductPage(@RequestParam("id") Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute(product);
		return "updateProductPage";

	}

	@RequestMapping(value = "/eproductUpdate", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/product/eproductDetails";

	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") Long id) {
		productService.deleteProduct(id);

		return "redirect:/product/eproductDetails";
	}

	@RequestMapping("/dashboard")
	public String getMostProfitableProductsList(Model model) {

		List<Product> mosstProfitableProducts = productService.getMostProfitableProduct();

		model.addAttribute("mosstProfitableProducts", mosstProfitableProducts);

		return "dashBoard";

	}

}
