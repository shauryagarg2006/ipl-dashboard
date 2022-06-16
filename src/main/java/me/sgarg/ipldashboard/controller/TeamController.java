package me.sgarg.ipldashboard.controller;

import me.sgarg.ipldashboard.model.Match;
import me.sgarg.ipldashboard.model.Team;
import me.sgarg.ipldashboard.repository.MatchRepository;
import me.sgarg.ipldashboard.repository.TeamRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/team")
    public Iterable<Team> getTeam() {
        return teamRepository.findAll();
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);

        return matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }

}
