package com.carlosreyes.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.carlosreyes.canciones.modelos.Cancion;
import com.carlosreyes.canciones.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {

    @Autowired
    private ServicioCanciones servicio;

    
    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        List<Cancion> lista = servicio.obtenerTodasLasCanciones();
        model.addAttribute("canciones", lista);
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String detalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancion); 
        return "detalleCancion";
    }
}
