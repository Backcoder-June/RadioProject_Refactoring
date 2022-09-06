package comment;

import java.util.HashMap;
import java.util.List;

import comment.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

	@Autowired
	CommentDAO commentDAO;

	@ResponseBody
	@PostMapping("/board/{boardSeq}/getAllComment")
	public Object getAllComment(@PathVariable("boardSeq") int seq) {
		List<CommentDTO> commentList = commentDAO.getAllComment(seq);

		return commentList;
	}

	@ResponseBody
	@PostMapping("/board/{boardSeq}/insertComment")
	public CommentDTO insertComment(@PathVariable("boardSeq") int seq, CommentDTO dto) {
		commentDAO.insertComment(dto);
		return commentDAO.getComment(dto.getCommentSeq());
	}

	@ResponseBody
	@PostMapping( "/board/{boardSeq}/updateComment")
	public CommentDTO updateComment(CommentDTO dto, String updateContents, int updateSecret, String commentSeq) {
		int commentSeqInt = Integer.parseInt(commentSeq);
		dto.setContents(updateContents);
		dto.setSecret(updateSecret);
		dto.setCommentSeq(commentSeqInt);

		commentDAO.updateComment(dto);
		return commentDAO.getComment(commentSeqInt);
	}

	@ResponseBody
	@PostMapping("/board/{boardSeq}/deleteComment")
	public void deleteComment(int commentSeq) {
		commentDAO.deleteComment(commentSeq);
	}
}
