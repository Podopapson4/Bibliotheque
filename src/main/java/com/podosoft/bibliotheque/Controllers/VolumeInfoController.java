package com.podosoft.bibliotheque.Controllers;

import com.podosoft.bibliotheque.Models.VolumeInfo;
import com.podosoft.bibliotheque.Services.VolumeInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volumeInfo")
@CrossOrigin
public class VolumeInfoController {
    final VolumeInfoService volumeInfoService;

    public VolumeInfoController(VolumeInfoService volumeInfoService) {
        this.volumeInfoService = volumeInfoService;
    }

    @GetMapping("/getVolumeInfoPage")
    public ResponseEntity<List<VolumeInfo>> getVolumeInfoPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return new ResponseEntity<>(volumeInfoService.getVolumeInfoPage(pageNum, pageSize), HttpStatus.OK);
    }

}
