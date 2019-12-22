package ru.neshin.posta.controllers;

import ru.neshin.posta.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neshin.posta.service.UserService;

import java.util.List;

@RestController
@Api(tags = "Users", description = "Users management / Управление пользователями")
@Secured({"ADMIN"})
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    @ApiOperation(value = "Get all users / Получить всех пользователей")
    public List<UserDto> index(Model model) {
        return userService.getAllUsers();
    }

}
