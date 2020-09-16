import * as React from "react";
import config from "../../config";

class Dashboard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            items: []
        };
    }

    componentDidMount() {
        fetch(`${config.baseUrl}/preference/1`)
            .then(res => res.json())
            .then(
                (result) => {
                    console.log( result );
                    this.setState({
                        isLoaded: true,
                        items: result.sports
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    render() {
        const { error, isLoaded, items } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {
            return (
                <ul>
                    {items.map(item => (
                        <li key={item.strSport}>
                            <img src={item.strSportThumb} alt={item.strSport}/>
                            {item.strSport}
                        </li>
                    ))}
                </ul>
            );
        }
    }
}

export default Dashboard;
