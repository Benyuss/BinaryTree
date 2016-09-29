package hu.benyuss.binaryTree.webserver;

import hu.benyuss.binaryTree.webserver.service.BinaryTreeInit;
import hu.benyuss.binaryTree.webserver.service.BinaryTreeProcess;
import hu.benyuss.binaryTree.binaryTreeUtils.traversing.TraversConst;
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
    public String indexPage(ModelMap model) { //ModelMap is a holder which stores modelAttributes.
        return "index";
    }

    @PostMapping(value = "/index", params = "index")
    public ModelAndView redirect(ModelMap model) {
        return new ModelAndView("redirect:index");
    }

    @PostMapping(value = "/manual-input")
    public String manualInput(ModelMap model) {
        model.put("command", new BinaryTreeInit());
        return "manualinput";
    }

    @PostMapping(value = "/manual-input", params = "submit")
    public String manualInput(@ModelAttribute("custom") BinaryTreeInit binaryTree, HttpSession session) {
        //i've used session instead of another model pass, because model can only pass trough 2 controllers while
        //session is more agile.
        logger.info("Bits of the given tree: " + binaryTree.getBits());
        session.setAttribute("tree", binaryTree);
        return "index";
    }

    @PostMapping(value = "/upload")
    public String upload(ModelMap model) {
        return "genomupload";
    }

    @PostMapping(value = "/upload", params = "up")
    public String upload(@RequestParam("genomfile") MultipartFile file, HttpSession session) {

        BinaryTreeInit binaryTree = new BinaryTreeInit();
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
        BinaryTreeInit processableTree = (BinaryTreeInit) session.getAttribute("tree");
        BinaryTreeProcess processedTree = new BinaryTreeProcess();
        processedTree.setTravWay((travWay));
        logger.debug("User decided to traverse trough the tree in " + travWay + " way.");

        model.addAllAttributes(processedTree.processTree(processableTree.getBits()));
        return "draw";
    }

}
