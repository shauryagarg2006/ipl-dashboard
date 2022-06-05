package me.sgarg.ipldashboard.data;

import me.sgarg.ipldashboard.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);


    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setResult(matchInput.getResult());
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setResultMargin(matchInput.getResult_margin());
        match.setTossDecision(matchInput.getToss_decision());
        match.setTossWinner(matchInput.getToss_winner());
        //First innings team will be the team which batted first
        String firstInningsTeam, secondInningsTeam;
        if ("bat".equals(matchInput.getToss_decision())) {
            firstInningsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : match.getTeam1();
        } else {
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : match.getTeam1();
            secondInningsTeam = matchInput.getToss_winner();
        }
        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        match.setVenue(matchInput.getVenue());
        match.setWinner(matchInput.getWinner());

        return match;
    }
}
