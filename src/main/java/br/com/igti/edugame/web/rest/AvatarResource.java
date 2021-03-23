package br.com.igti.edugame.web.rest;

import br.com.igti.edugame.domain.Avatar;
import br.com.igti.edugame.service.AvatarService;
import java.net.URISyntaxException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avatar")
public class AvatarResource {
    @Autowired
    private AvatarService avatarService;

    @GetMapping("/detalhar")
    public ResponseEntity<Avatar> createUser(@Valid @RequestBody Long avatarId) throws URISyntaxException {
        Avatar avatar = avatarService.detalharAvatar(avatarId);
        return new ResponseEntity<Avatar>(avatar, HttpStatus.OK);
    }
}
