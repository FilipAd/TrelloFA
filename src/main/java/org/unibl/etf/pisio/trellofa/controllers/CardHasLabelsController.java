package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.CardHasLabels;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.models.requests.CardHasLabelsRequest;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;
import org.unibl.etf.pisio.trellofa.services.CardHasLabelsService;

import java.util.List;

@RestController
@RequestMapping("/cardhaslabels")
public class CardHasLabelsController
{
    private final CardHasLabelsService service;

    public CardHasLabelsController(CardHasLabelsService service)
    {
        this.service = service;
    }

    @GetMapping
    List<CardHasLabels> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{id}")
    CardHasLabels findById(@PathVariable Integer id) throws NotFoundException
    {
        return  service.findById(id);
    }

    @GetMapping("/bycardid/{id}")
    List<CardHasLabels> findByCardId(@PathVariable Integer id) throws NotFoundException
    {
        return  service.findAllCardHasLabelsByCardId(id);
    }

    @GetMapping("/{idCard}/{idLabel}")
    List<CardHasLabels> findByCardAndLabel(@PathVariable Integer idCard,@PathVariable Integer idLabel) throws NotFoundException
    {
        return  service.findAllCardHasLabelsByCardAndLabel(idCard,idLabel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)throws NotFoundException
    {
        service.delete(id);
    }

    @DeleteMapping("/delete/{idCard}/{idLabel}")
    public void deleteByCardIdAndLabelId(@PathVariable Integer idCard,@PathVariable Integer idLabel)throws NotFoundException
    {
        service.deleteAllCardHasLabelsByCardIdAndLabelId(idCard,idLabel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardHasLabels insert(@RequestBody CardHasLabelsRequest cardHasLabelsRequest)throws NotFoundException
    {
        return service.insert(cardHasLabelsRequest);
    }

    @PutMapping("/{id}")
    public CardHasLabels update(@PathVariable Integer id, @RequestBody CardHasLabelsRequest cardHasLabelsRequest)throws NotFoundException
    {
        return service.update(id,cardHasLabelsRequest);
    }
}
