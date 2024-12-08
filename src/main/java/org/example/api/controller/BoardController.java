package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.GetBoardResponseDTO;
import org.example.api.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;


    @GetMapping
    public String getAllBoards(Model model){
        List<GetBoardResponseDTO> boards = boardService.findAllBoards();
        model.addAttribute("boards", boards);
        return "index";
    }
}
