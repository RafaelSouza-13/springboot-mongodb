package com.rafael.springbootmondodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.springbootmondodb.domain.User;
import com.rafael.springbootmondodb.dto.UserDto;
import com.rafael.springbootmondodb.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> findAll(){
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(user));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto userDto){
        User user = service.fromDto(userDto);
        service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }
}
