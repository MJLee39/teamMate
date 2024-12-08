package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.GetBoardResponseDTO;
import org.example.api.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/board")
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<GetBoardResponseDTO>> getAllBoards(){
        List<GetBoardResponseDTO> boards = boardService.findAllBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping(value = "/read/{boardId}")
    public GetBoardResponseDTO getBoardByBoardId(@PathVariable(value = "boardId") Long boardId){
        return boardService.getBoardById(boardId);
    }

}
