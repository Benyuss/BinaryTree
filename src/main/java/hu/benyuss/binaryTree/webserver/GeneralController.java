package hu.benyuss.binaryTree.webserver;

import hu.benyuss.binaryTree.BinaryTreeExecute;
import hu.benyuss.binaryTree.BinaryTreeProcess;
import hu.benyuss.binaryTree.traversing.TraversConst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class GeneralController {

    private static final Logger logger = (Logger) LogManager.getLogger(GeneralController.class.getName());

    @GetMapping(value = "/index")
    public String indexPage(ModelMap model) {
        return "index";
    }

    @PostMapping(value = "/index", params = "index")
    public ModelAndView redirect(ModelMap model) {
        return new ModelAndView("redirect:index");
    }

    @PostMapping(value = "/manual-input")
    public String manualInput(ModelMap model) {
        model.put("command", new BinaryTreeExecute());
        return "manualinput";
    }

    @PostMapping(value = "/manual-input", params = "submit")
    public String manualInput(@ModelAttribute("custom") BinaryTreeExecute binaryTree, HttpSession session) {

        logger.info("Bits of that tree: " + binaryTree.getBits());
        session.setAttribute("tree", binaryTree);
        return "index";
    }

    @PostMapping(value = "/upload")
    public String upload(ModelMap model) {
        return "genomupload";
    }

    @PostMapping(value = "/upload", params = "up")
    public String upload(@RequestParam("genomfile") MultipartFile file, HttpSession session) {

        BinaryTreeExecute binaryTree = new BinaryTreeExecute();
        binaryTree.fileInput('f', file);

        session.setAttribute("tree", binaryTree);

        return "redirect:index";
    }

    @PostMapping(value = "/choose-tree")
    public String choose(ModelMap model) {
        model.addAttribute("command", new BinaryTreeProcess());
        model.addAttribute("enums", TraversConst.values());

        return "choose";
    }

    @PostMapping(value = "/choose-tree", params = "index")
    public ModelAndView redirect2Index(ModelMap model) {
        return new ModelAndView("redirect:index");
    }

    @PostMapping(value = "/draw-tree")
    public String process(HttpSession session, @ModelAttribute("travWay") TraversConst travWay, ModelMap model) {
        BinaryTreeExecute tree = (BinaryTreeExecute) session.getAttribute("tree");
        BinaryTreeProcess realTree = new BinaryTreeProcess();
        realTree.setTravWay((travWay));

        model.addAllAttributes(realTree.makefun(tree.getBits()));
        return "draw";
    }

}
