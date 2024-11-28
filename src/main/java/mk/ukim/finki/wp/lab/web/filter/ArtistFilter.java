package mk.ukim.finki.wp.lab.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter(filterName = "artist-filter", urlPatterns = "/*",
//        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
//        initParams = {
//                @WebInitParam(name = "ignore-path", value = "/listSongs"),
//                @WebInitParam(name = "ignore-path-artist", value = "/artist"),
//        })
//public class ArtistFilter implements Filter {
//    private String ignorePath;
//    private String ignorePathArtist;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//        ignorePath = filterConfig.getInitParameter("ignore-path");
//        ignorePathArtist = filterConfig.getInitParameter("ignore-path-artist");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String path = req.getServletPath();
//        String trackId = req.getParameter("trackId");
//        String artistId = req.getParameter("artistId");
////        filterChain.doFilter(req, resp);
////        if (path.startsWith(ignorePathArtist) && artistId != null && trackId != null) {
////            filterChain.doFilter(servletRequest, servletResponse);
////        } else if (path.startsWith(ignorePathArtist) && artistId == null && trackId != null) {
////            resp.sendRedirect("/artist" + "?trackId=" + trackId);
////        } else if (path.startsWith(ignorePath) && trackId != null){
////            filterChain.doFilter(servletRequest, servletResponse);
////        }
//
//        if (path.startsWith(ignorePathArtist) && trackId == null) {
//            resp.sendRedirect("/listSongs");
//        } else if (path.startsWith(ignorePath) || trackId != null || path.startsWith(ignorePathArtist) || artistId != null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            resp.sendRedirect("/artist?trackId" + trackId);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
