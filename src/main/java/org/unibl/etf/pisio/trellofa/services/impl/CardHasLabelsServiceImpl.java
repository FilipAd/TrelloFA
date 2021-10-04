package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.BoardHasMembers;
import org.unibl.etf.pisio.trellofa.models.CardHasLabels;
import org.unibl.etf.pisio.trellofa.models.entities.BoardHasMembersEntity;
import org.unibl.etf.pisio.trellofa.models.entities.CardHasLabelsEntity;
import org.unibl.etf.pisio.trellofa.models.requests.BoardHasMembersRequest;
import org.unibl.etf.pisio.trellofa.models.requests.CardHasLabelsRequest;
import org.unibl.etf.pisio.trellofa.repositories.BoardHasMembersEntityRepository;
import org.unibl.etf.pisio.trellofa.repositories.CardHasLabelsEntityRepository;
import org.unibl.etf.pisio.trellofa.services.BoardHasMembersService;
import org.unibl.etf.pisio.trellofa.services.CardHasLabelsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CardHasLabelsServiceImpl implements CardHasLabelsService
{
    private final CardHasLabelsEntityRepository repository;
    private final ModelMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public CardHasLabelsServiceImpl(CardHasLabelsEntityRepository repository, ModelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<CardHasLabels> findAll()
    {
        return repository.findAll().stream().map(e->mapper.map(e,CardHasLabels.class)).collect(Collectors.toList());
    }

    @Override
    public List<CardHasLabels> findAllCardHasLabelsByCardId(Integer id)
    {
        return repository.getAllByCard_Id(id).stream().map(e->mapper.map(e,CardHasLabels.class)).collect(Collectors.toList());
    }

    @Override
    public List<CardHasLabels> findAllCardHasLabelsByLabelId(Integer id)
    {
        return repository.getAllByLabel_Id(id).stream().map(e->mapper.map(e,CardHasLabels.class)).collect(Collectors.toList());
    }

    @Override
    public List<CardHasLabels> findAllCardHasLabelsByCardAndLabel(Integer idCard, Integer idLabel)
    {
        return repository.getAllByCard_IdAndLabel_Id(idCard,idLabel).stream().map(e->mapper.map(e,CardHasLabels.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteAllCardHasLabelsByCardIdAndLabelId(Integer idCard, Integer idLabel) {
         repository.deleteAllByCard_IdAndLabel_Id(idCard,idLabel);
    }

    @Override
    public CardHasLabels findById(Integer id) throws NotFoundException
    {
        return mapper.map(repository.findById(id).orElseThrow(NotFoundException::new),CardHasLabels.class);
    }

    @Override
    public void delete(Integer id)throws NotFoundException
    {
        repository.deleteById(id);
    }

    @Override
    public CardHasLabels insert(CardHasLabelsRequest cardHasLabelsRequest)throws NotFoundException
    {
        CardHasLabelsEntity cardHasLabelsEntity=mapper.map(cardHasLabelsRequest,CardHasLabelsEntity.class);
        cardHasLabelsEntity.setId(null);
        cardHasLabelsEntity=repository.saveAndFlush(cardHasLabelsEntity);
        entityManager.refresh(cardHasLabelsEntity);
        return findById(cardHasLabelsEntity.getId());

    }

    @Override
    public CardHasLabels update(Integer id, CardHasLabelsRequest cardHasLabelsRequest) throws NotFoundException
    {
        CardHasLabelsEntity cardHasLabelsEntity=mapper.map(cardHasLabelsRequest,CardHasLabelsEntity.class);
        cardHasLabelsEntity.setId(id);
        cardHasLabelsEntity=repository.saveAndFlush(cardHasLabelsEntity);
        entityManager.refresh(cardHasLabelsEntity);
        return findById(cardHasLabelsEntity.getId());
    }
}
