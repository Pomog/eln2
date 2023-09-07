package com.ElnMarvin.elnV2;

import com.ElnMarvin.elnV2.core.domain.Person;
import com.ElnMarvin.elnV2.core.domain.StructureData;
import org.openscience.cdk.AtomContainer;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.interfaces.IAtomContainer;
import org.openscience.cdk.io.MDLV2000Reader;
import org.openscience.cdk.smiles.SmiFlavor;
import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MVCTest1 {
    @RequestMapping(value = {"/MVCDemoServlet"})
    public ModelAndView doGet() {
        String structure = "water";

        ModelAndView modelAndView = new ModelAndView("MVCDemoView");
        modelAndView.addObject("structure", structure);

        return modelAndView;
    }

    @GetMapping ("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "John Doe");
        return "hello";
    }

    @GetMapping ("/addCSS-JS-Test")
    public String style(Model model) {
        return "addCSS-JS-Test";
    }

    @GetMapping ("/bootstrapTest")
    public String bootStrapTest(Model model) {
        List people = new ArrayList();
        people.add(new Person(1L, "John", "Doe", 20));
        people.add(new Person(2L, "Jane", "Doe", 15));
        people.add(new Person(3L, "John", "Smith", 30));

        model.addAttribute("people", people);
        return "bootstrapTest";
    }

    @GetMapping ("/getStructure")
    public String getStructure(Model model) {
        return "getStructure";
    }

    @PostMapping("/submitMolsource")
    public String submitMolsource(@RequestParam("molsource") String molsource, Model model) {

        MDLV2000Reader mdlv2000Reader = new MDLV2000Reader(new StringReader(molsource));
        IAtomContainer molecule;
        try {
            molecule = mdlv2000Reader.read(new AtomContainer());
        } catch (CDKException e) {
            throw new RuntimeException(e);
        }

        SmilesGenerator smigen = new SmilesGenerator(SmiFlavor.UseAromaticSymbols);
        try {
            String smiles = smigen.create(molecule);
            System.out.println("SMILES: " + smiles);
        } catch (CDKException e) {
            throw new RuntimeException(e);
        }

        AtomContainerManipulator.convertImplicitToExplicitHydrogens(molecule);
        StructureData structureData = new StructureData(molecule);
        System.out.println(structureData.getBruttoFormula());
        System.out.printf("MW [%.2f]%n", structureData.getMW());

        // Redirect to a success page or another view
        return "sucsessGetMol"; // Create a "success.html" view for displaying a success message
    }
}
