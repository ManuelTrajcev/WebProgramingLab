package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "artist-servlet", urlPatterns = "/artist")
public class АrtistServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final ArtistService artistService;
    private final SongService songService;

    public АrtistServlet(SpringTemplateEngine templateEngine, ArtistService artistService, SongService songService) {
        this.templateEngine = templateEngine;
        this.artistService = artistService;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String trackId = req.getParameter("trackId");
        Song song = songService.findByTrackId(trackId);
        context.setVariable("song", song);
        context.setVariable("artists", artistService.listArtists());

        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistId = req.getParameter("artistId");
        String trackId = req.getParameter("trackId");
        Artist artist = artistService.ArtistfindById(Long.valueOf((artistId)));
        Song song = songService.findByTrackId(trackId);
        if (artistId != null && trackId != null) {
            songService.addArtistToSong(artist, song);
        }
        resp.sendRedirect(req.getContextPath() + "/songDetails?trackId=" + trackId + "&artistId=" + artistId);

    }
}
