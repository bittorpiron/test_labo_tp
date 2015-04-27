
package org.equipe21.projetsession;

public interface LectureFichier {
    
    
    boolean lireFichier(String cheminAcces, String encodage);
    
    
    Object getObjetSortie() throws ErreurValeurFichierEntreeException;
    
}
