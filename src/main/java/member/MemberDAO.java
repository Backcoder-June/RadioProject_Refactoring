package member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberDAO {

    public List<MemberDTO> memberlist();
    public MemberDTO logincheck(String id);

    public int insertmember(MemberDTO dto);

    public int deleteMember(String id);

    public MemberDTO selectOneMember(String id);

    public int updateMember(MemberDTO dto);
}
