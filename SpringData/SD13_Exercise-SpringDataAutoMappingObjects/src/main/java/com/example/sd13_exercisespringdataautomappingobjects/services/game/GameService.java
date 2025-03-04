package com.example.sd13_exercisespringdataautomappingobjects.services.game;

public interface GameService {

    String addGame(String[] gameData);

    String editGame(String[] gameData) throws Exception;

    String deleteGame(String[] gameData);


    String getAllGames();

    String getInfoAboutAGame(String[] data);
}
