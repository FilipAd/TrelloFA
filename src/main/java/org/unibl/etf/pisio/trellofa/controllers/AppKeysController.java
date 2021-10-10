package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.AppKeys;
import org.unibl.etf.pisio.trellofa.models.Attachment;
import org.unibl.etf.pisio.trellofa.models.entities.AttachmentEntity;
import org.unibl.etf.pisio.trellofa.models.requests.AppKeysRequest;
import org.unibl.etf.pisio.trellofa.models.requests.AttachmentRequest;
import org.unibl.etf.pisio.trellofa.services.AppKeysService;
import org.unibl.etf.pisio.trellofa.services.AttachmentService;

import java.nio.file.NotDirectoryException;
import java.util.List;

@RestController
@RequestMapping("/appkeys")
public class AppKeysController
{
    private final AppKeysService appKeysService;

    public AppKeysController(AppKeysService  appKeysService)
    {
        this.appKeysService = appKeysService;
    }


    @GetMapping
    List<AppKeys> findAll()
    {
        return appKeysService.findAll();
    }
    @GetMapping("/{key}")
    AppKeys findById(@PathVariable String key) throws NotFoundException
    {
        return appKeysService.findByKeys(key);
    }
    @DeleteMapping("/{key}")
    public void delete(@PathVariable String key)throws NotFoundException
    {
        appKeysService.deleteByKey(key);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppKeys insert(@RequestBody AppKeysRequest appKeysRequest)throws NotFoundException
    {
        return appKeysService.insert(appKeysRequest);
    }

   


}
