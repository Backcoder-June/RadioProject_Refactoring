package board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@Autowired
	BoardDAO boardDAO;

	// 전체 게시물 조회(페이징)
	@GetMapping("/boardList")
	public String boardlistPaging(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		int countBoard = boardDAO.countBoard();
		int totalPage = 0;
		if (countBoard % 10 == 0) {
			totalPage = countBoard / 10;
		} else {
			totalPage = countBoard / 10 + 1;
		}

		int limitpage = (page-1)*10;
		List<BoardDTO> boardListPaging = boardDAO.limitBoard(limitpage);

		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boardlist", boardListPaging);

		return "board/boardList";
	}

	// 게시물 작성
	@GetMapping("/writingBoard")
	public String writingBoard() {
		return "board/writingForm";
	}

	// 게시물 저장
	@PostMapping("/writingBoard")
	public String saveBoard(BoardDTO dto) {
		boardDAO.saveBoard(dto);
		return "redirect:/boardList";
	}

	// 해당 게시물 조회
	@GetMapping("/board/{boardSeq}")
	public String oneBoard(@PathVariable("boardSeq") int seq, Model model) {
		boardDAO.viewCount(seq);

		BoardDTO targetBoard = boardDAO.oneBoard(seq);
		model.addAttribute("oneBoard", targetBoard);

		return "board/oneBoard";
	}

	// 게시물 삭제
	@GetMapping("/deleteBoard/{deleteBoardSeq}")
	public String deleteBoard(@PathVariable("deleteBoardSeq")int deleteBoardSeq) {
		boardDAO.deleteBoard(deleteBoardSeq);

		return "redirect:/boardList";
	}


	// 게시물 수정 페이지
	@GetMapping("/editBoard/{editSeq}")
	public String editBoardForm(@PathVariable("editSeq") int editSeq, Model model) {
		model.addAttribute("editTarget", boardDAO.oneBoard(editSeq));
		return "board/editBoardForm";
	}

	// 게시물 수정 update
	@PostMapping("/editBoard/{editSeq}")
	public String editBoardProcess(BoardDTO boardDTO) {
		int result = boardDAO.editBoard(boardDTO);
		return "redirect:/boardList";
	}

	// 추천 좋아요
	@ResponseBody
	@PostMapping("/board/like")
	public String updateLike(int boardseq, String memberid) throws Exception {

		int likeCheck = boardDAO.likeCheck(boardseq, memberid);
		if (likeCheck == 0) {
			boardDAO.insertLike(boardseq, memberid);
			boardDAO.updateLike(boardseq);
		} else if (likeCheck == 1) {
			boardDAO.updateLikeCancel(boardseq);
			boardDAO.deleteLike(boardseq, memberid);
		}

		int likeNum = boardDAO.likeCount(boardseq);

		return "{\"result\" : \"" + likeCheck + "\", \"result2\" : \"" + likeNum + "\" }";
	}

	// 검색
	@GetMapping("/searchboard")
	public String searchList(String item, String search, Model model) {

		HashMap<String, String> map = new HashMap();
		map.put("item", item);
		map.put("search", search);

		List<BoardDTO> searchList = boardDAO.searchList(map);

		model.addAttribute("boardlist", searchList);
		return "board/boardList2";
	}
}