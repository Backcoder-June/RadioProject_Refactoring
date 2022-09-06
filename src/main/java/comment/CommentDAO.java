package comment;

import java.util.List;

import comment.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentDAO {

	// 댓글 추가
	public int insertComment(CommentDTO dto);

	public CommentDTO getComment(int commentSeq);

	public List<CommentDTO> getAllComment(int seq);

	public void updateComment(CommentDTO dto);

	public void deleteComment(int commentSeq);
}
