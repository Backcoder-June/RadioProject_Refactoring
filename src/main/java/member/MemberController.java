package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberDAO memberDAO;


    @GetMapping("/")
    public String home(HttpSession session) {
        String id = (String) session.getAttribute("id");

        if (id != null) {
            return "login/loginresult";
        } else {
            return "login/home";
        }

    }

    @GetMapping("/login")
    public String loginform() {
        return "login/login";
    }

    @PostMapping("/loginprocess")
    public String loginprocess(String id, int password, HttpSession session, Model model) {

        if (memberDAO.logincheck(id) == null) {
            model.addAttribute("message", "error");
            return "login/login";
        } else {
            int dbpw = memberDAO.logincheck(id).getPassword();

            if (dbpw == password) {
                session.setAttribute("id", id);
                session.setAttribute("password", password);
                return "login/loginresult";
            } else {
                model.addAttribute("message", "error");
                return "login/login";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }


    @GetMapping("/signin")
    public String signin(){
        return "login/singinform";
    }

    @PostMapping("/signin")
    public String signinprocess(MemberDTO dto) {

        memberDAO.insertmember(dto);

        return "redirect:/";
    }


    @GetMapping("/deletemember")
    public String deleteprocess(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        memberDAO.deleteMember(id);
        session.invalidate();
        return "login/login";

    }


    @GetMapping("/memberupdate")
    public String updateMember(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        MemberDTO editTarget = memberDAO.selectOneMember(id);

        model.addAttribute("updateform", editTarget);

        return "login/updateform";
    }

    @PostMapping("/memberupdate")
    public String updateMemberprocess(MemberDTO dto) {
        memberDAO.updateMember(dto);
        return "redirect:/";
    }




    //아이디 체크
    @ResponseBody
    @PostMapping("/idChk")
    public int idChk(String id) {
        System.out.println(id);
        MemberDTO result = memberDAO.logincheck(id);
        System.out.println(result);
        int idChk = 0;
        if (result != null) {
            idChk = 1;
        }
        return idChk;
    }


    //
}
