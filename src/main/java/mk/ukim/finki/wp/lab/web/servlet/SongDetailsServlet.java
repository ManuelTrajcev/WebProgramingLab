//package mk.ukim.finki.wp.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.repository.InMemoryRepositories.InMemorySongRepository;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@WebServlet(name = "song-details-servlet", urlPatterns = "/songDetails")
//public class SongDetailsServlet extends HttpServlet {
//    private final InMemorySongRepository songRepository;
//    private final SpringTemplateEngine templateEngine;
//
//    public SongDetailsServlet(InMemorySongRepository songRepository, SpringTemplateEngine templateEngine) {
//        this.songRepository = songRepository;
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        String trackId = req.getParameter("trackId");
//        Optional<Song> song = songRepository.findByTrackId(trackId);
//        Song savedSong = song.get();
//        context.setVariable("song", savedSong);
//
//        templateEngine.process("songDetails.html", context, resp.getWriter());
//    }
//}
