package com.ejemplo.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ejemplo.demo.forms.ProductForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    private static final List<Map<String, String>> products = new ArrayList<>(List.of(
            Map.of("id", "1", "name", "TV", "description", "Best TV", "price", "500",
                    "image",
                    "https://www.apple.com/newsroom/images/2023/12/redesigned-apple-tv-app-simplifies-the-viewing-experience/tile/Apple-TV-app-home-screen-lp.jpg.og.jpg?202501141956"),
            Map.of("id", "2", "name", "iPhone", "description", "Best iPhone", "price", "999",
                    "image",
                    "https://www.telstra.com.au/content/dam/tcom/devices/mobile/mhdwhst-16pm/deserttitanium/landscape-apple-iphone16promax-deserttitianium-02-900x1200.jpg"),
            Map.of("id", "3", "name", "Chromecast", "description", "Best Chromecast", "price", "35",
                    "image",
                    "https://s1.elespanol.com/2017/06/27/actualidad/actualidad_226990894_129938048_1200x630.jpg"),
            Map.of("id", "4", "name", "Glasses", "description", "Best Glasses", "price", "150",
                    "image",
                    "https://www.apple.com/newsroom/images/media/introducing-apple-vision-pro/Apple-WWDC23-Vision-Pro-glass-230605_big.jpg.large.jpg")));

    @GetMapping("/products")
    public String index(Model model) {
        model.addAttribute("title", "Products - Online Store");
        model.addAttribute("subtitle", "List of products");
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/products/create")
    public String create(Model model) {
        model.addAttribute("title", "Create Product");
        model.addAttribute("productForm", new ProductForm());
        return "product/create";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute ProductForm productForm, RedirectAttributes redirectAttributes) {
        if (productForm.getPrice() <= 0) {
            redirectAttributes.addFlashAttribute("errorMessage", "El precio debe ser mayor a cero.");
            return "redirect:/products/create";
        }

        int formattedPrice = productForm.getPrice().intValue();

        Map<String, String> newProduct = Map.of(
                "id", String.valueOf(products.size() + 1),
                "name", productForm.getName(),
                "description", "Nuevo Producto",
                "price", String.valueOf(formattedPrice),
                "image",
                "https://www.fedex.com/content/dam/fedex/us-united-states/shipping/images/2020/Q3/FeBox_Retail_Square_Rectangular_Group_042117_2102362276.jpg");

        products.add(newProduct);

        redirectAttributes.addFlashAttribute("successMessage", "¡Producto creado exitosamente!");

        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String show(@PathVariable String id, Model model) {
        int productId;
        try {
            productId = Integer.parseInt(id) - 1;
        } catch (NumberFormatException e) {
            return "redirect:/products"; // Redirect if ID is not a valid number
        }

        if (productId < 0 || productId >= products.size()) {
            return "redirect:/products"; // Redirect if ID is out of bounds
        }

        Map<String, String> product = products.get(productId);

        int price;
        try {
            price = Integer.parseInt(product.get("price"));
        } catch (NumberFormatException e) {
            price = 0;
        }

        model.addAttribute("title", product.get("name") + " - Online Store");
        model.addAttribute("subtitle", product.get("name") + " - Product Information");
        model.addAttribute("product", product);
        model.addAttribute("price", price);

        return "product/show";
    }

}
