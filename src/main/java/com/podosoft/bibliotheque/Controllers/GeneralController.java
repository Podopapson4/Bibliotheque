package com.podosoft.bibliotheque.Controllers;

import com.podosoft.bibliotheque.Models.*;
import com.podosoft.bibliotheque.Requests.GeneralRequest;
import com.podosoft.bibliotheque.Responses.GeneralResponse;
import com.podosoft.bibliotheque.Services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GeneralController {
    GeneralRequest generalRequest = new GeneralRequest();
    final ItemService itemService;
    final VolumeInfoService volumeInfoService;
    final SaleInfoService saleInfoService;
    final AccessInfoService accessInfoService;
    final SearchInfoService searchInfoService;

    public GeneralController(ItemService itemService, VolumeInfoService volumeInfoService, SaleInfoService saleInfoService, AccessInfoService accessInfoService, SearchInfoService searchInfoService) {
        this.itemService = itemService;
        this.volumeInfoService = volumeInfoService;
        this.saleInfoService = saleInfoService;
        this.accessInfoService = accessInfoService;
        this.searchInfoService = searchInfoService;
    }


    @GetMapping("/getBooksVolumes")
    public ResponseEntity<GeneralResponse> getBooksVolumes(@RequestParam("query") String query){


        GeneralResponse generalResponse = generalRequest.getBooksVolumes(query);

        if (generalResponse != null) {
            for (Item item : generalResponse.getItems()){

                try {
                    // save Item
                    Item itemSaved = itemService.save(item);
                    if (itemSaved != null) {
                        item.setBdId(itemSaved.getBdId());

                        // VolumeInfo
                        if (item.getVolumeInfo() != null) {
                            item.getVolumeInfo().setItemBdId(item.getBdId());
                            item.getVolumeInfo().setItemId(item.getId());
                            VolumeInfo volumeInfo = volumeInfoService.save(item.getVolumeInfo());
                        }

                        // SaleInfo
                        if (item.getSaleInfo() != null) {
                            item.getSaleInfo().setItemBdId(item.getBdId());
                            item.getSaleInfo().setItemId(item.getId());
                            SaleInfo saleInfo = saleInfoService.save(item.getSaleInfo());
                        }

                        // AccessInfo
                        if (item.getAccessInfo() != null) {
                            item.getAccessInfo().setItemBdId(item.getBdId());
                            item.getAccessInfo().setItemId(item.getId());
                            AccessInfo accessInfo = accessInfoService.save(item.getAccessInfo());
                        }

                        // SearchInfo
                        if (item.getSearchInfo() != null) {
                            item.getSearchInfo().setItemBdId(item.getBdId());
                            item.getSearchInfo().setItemId(item.getId());
                            SearchInfo searchInfo = searchInfoService.save(item.getSearchInfo());
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("Duplicate Error ************************ " + item.getId());
                }
            }
        }
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }

    @GetMapping("/getBooksVolumesPage")
    public ResponseEntity<GeneralResponse> getBooksVolumesPage(@RequestParam("query") String query, @RequestParam("startIndex") int startIndex, @RequestParam("maxResults") int maxResults){


        GeneralResponse generalResponse = generalRequest.getBooksVolumesPage(query,startIndex, maxResults);

        if (generalResponse != null) {
            for (Item item : generalResponse.getItems()){

                try {
                    // save Item
                    Item itemSaved = itemService.save(item);
                    if (itemSaved != null) {
                        item.setBdId(itemSaved.getBdId());

                        // VolumeInfo
                        if (item.getVolumeInfo() != null) {
                            item.getVolumeInfo().setItemBdId(item.getBdId());
                            item.getVolumeInfo().setItemId(item.getId());
                            VolumeInfo volumeInfo = volumeInfoService.save(item.getVolumeInfo());
                        }

                        // SaleInfo
                        if (item.getSaleInfo() != null) {
                            item.getSaleInfo().setItemBdId(item.getBdId());
                            item.getSaleInfo().setItemId(item.getId());
                            SaleInfo saleInfo = saleInfoService.save(item.getSaleInfo());
                        }

                        // AccessInfo
                        if (item.getAccessInfo() != null) {
                            item.getAccessInfo().setItemBdId(item.getBdId());
                            item.getAccessInfo().setItemId(item.getId());
                            AccessInfo accessInfo = accessInfoService.save(item.getAccessInfo());
                        }

                        // SearchInfo
                        if (item.getSearchInfo() != null) {
                            item.getSearchInfo().setItemBdId(item.getBdId());
                            item.getSearchInfo().setItemId(item.getId());
                            SearchInfo searchInfo = searchInfoService.save(item.getSearchInfo());
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("Duplicate Error ************************ " + item.getId());
                }
            }
        }
        return new ResponseEntity<>(generalResponse, HttpStatus.OK);
    }
}
