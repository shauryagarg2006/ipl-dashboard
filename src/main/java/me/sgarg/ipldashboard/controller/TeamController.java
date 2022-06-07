package me.sgarg.ipldashboard.controller;

import me.sgarg.ipldashboard.model.Team;
import me.sgarg.ipldashboard.repository.MatchRepository;
import me.sgarg.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team t = teamRepository.findByTeamName(teamName);
        t.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
        return t;
    }

}
