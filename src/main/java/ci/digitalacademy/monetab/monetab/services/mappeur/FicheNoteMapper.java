package ci.digitalacademy.monetab.monetab.services.mappeur;

import ci.digitalacademy.monetab.monetab.models.FicheNote;
import ci.digitalacademy.monetab.monetab.services.dto.FicheNoteDTO;

public class FicheNoteMapper {

    private FicheNoteMapper(){}

    public static FicheNote toEntity(FicheNoteDTO ficheNoteDTO){
        FicheNote ficheNote = new FicheNote();
        return ficheNote;
    }
}
