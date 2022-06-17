import { React, useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';
import { PieChart } from 'react-minimal-pie-chart';

import './TeamPage.scss';


export const TeamPage = () => {

    const [team, setTeam] = useState({ matches: [] });
    const { teamName } = useParams();
    const endYear = process.env.REACT_APP_DATA_END_YEAR

    useEffect(
        () => {
            const fetchTeam = async () => {
                const response = await fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/${teamName}`);
                const data = await response.json();
                setTeam(data);
            }
            fetchTeam();
        }, [teamName]
    );
    if (!team || !team.teamName) {
        return <h1>Team not Found</h1>
    }
    return (
        <div className="TeamPage">
            <div className='team-name-section'>
                <h1 className='team-name'>{team.teamName}</h1>
            </div>
            <div className='win-loss-section'> Wins / Losses
                <PieChart
                    data={[
                        { title: 'Losses', value: team.totalMatches - team.totalWins, color: '#a34d5d' },
                        { title: 'Wins', value: team.totalWins, color: '#4da375' },
                    ]}
                />
            </div>
            <div className='match-details-section'>
                <h3>Latest Matches</h3>
                <MatchDetailCard teamName={team.teamName} match={team.matches[0]} />
            </div>

            {team.matches.slice(1).map(match => <MatchSmallCard teamName={team.teamName} key={match.id} match={match} />)}
            <div className='more-link'>
                <Link to={`/teams/${teamName}/matches/${endYear}`}> -More </Link>
            </div>

        </div>
    );
}
