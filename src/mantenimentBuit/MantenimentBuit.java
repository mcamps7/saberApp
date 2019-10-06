/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimentBuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * classe que permet mantenir a memòria una llista d'objectes de la classe V i
 * amb la clau V
 *
 * @author professor
 */
public class MantenimentBuit<K, V> {

    private Map<K, V> mapa = new TreeMap<>();

    public void alta(K clau, V valor) {
        if (mapa.get(clau) == null) {
            mapa.put(clau, valor);
        } else {
            throw new Error("Clau repetida");
        }
    }

    public void modifica(K clau, V valor) {
        if (mapa.get(clau) != null) {
            mapa.put(clau, valor);
        } else {
            throw new Error("Clau inexistent");
        }
    }

    public void esborra(K clau) {
        if (mapa.get(clau) != null) {
            mapa.remove(clau);
        } else {
            throw new Error("Clau inexistent");
        }
    }

    public List<V> llistaTots() {
        List<V> resultat = new ArrayList<V>();
        for (Map.Entry<K, V> aux : mapa.entrySet()) {
            resultat.add(aux.getValue());
        }
        return resultat;
    }

}
