package ci.digitalacademy.monetab.monetab.services.mappeur.impl;

import ci.digitalacademy.monetab.monetab.models.Professeur;
import ci.digitalacademy.monetab.monetab.services.dto.ProfesseurDTO;

public final class ProfesseurMapper {

    private ProfesseurMapper(){}

    public static ProfesseurDTO toDto(Professeur professeur){
        ProfesseurDTO professeurDTO = new ProfesseurDTO();
        professeurDTO.setId(professeur.getId());
        professeurDTO.setGenre(professeur.getGenre());
        professeurDTO.setNom(professeur.getNom());
        professeurDTO.setPrenom(professeur.getPrenom());
        professeurDTO.setVacant(professeur.getVacant());
        professeurDTO.setMatiere(professeur.getMatiere());
        professeurDTO.setAge(professeur.getAge());
        professeurDTO.setTelephone(professeur.getTelephone());
        professeurDTO.setVille(professeur.getVille());
        return professeurDTO;
    }
    public static Professeur toEntity(ProfesseurDTO professeurDTO){
        Professeur professeur = new Professeur();
        professeur.setId(professeurDTO.getId());
        professeur.setGenre(professeurDTO.getGenre());
        professeur.setNom(professeurDTO.getNom());
        professeur.setPrenom(professeurDTO.getPrenom());
        professeur.setVacant(professeurDTO.getVacant());
        professeur.setAge(professeurDTO.getAge());
        professeur.setVille(professeurDTO.getVille());
        professeur.setTelephone(professeurDTO.getTelephone());
        professeur.setMatiere(professeurDTO.getMatiere());
        return professeur;
    }
}
