package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.routeDTO.*;
import bg.softuni.pathfinder.model.entity.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    MostCommentedDTO getMostCommented();

    RouteDetailDTO getRouteDetails(Long id);

    List<AllRoutesDTO> findAllRoutes();

    List<AllRoutesDTO> findRouteByCategory(String categoryName);

    boolean addNewRoute(RouteRegisterDTO routeDTO);

    Optional<Route> findById(Long routeId);
}
