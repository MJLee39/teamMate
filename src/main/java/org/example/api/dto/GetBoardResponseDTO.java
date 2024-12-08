package org.example.api.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.domain.board.Board;

@Getter
public class GetBoardResponseDTO {

    private final Long boardId;
    private final String title;
    private final String content;

    @Builder
    public GetBoardResponseDTO(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }

    public static GetBoardResponseDTO fromEntity(Board board) {
        return GetBoardResponseDTO.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }

}
