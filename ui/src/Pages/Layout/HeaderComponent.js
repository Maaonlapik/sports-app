import * as React from "react";
import '../../App.css';
import './Header.css';

export class HeaderComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            items: [],
            favourites: []
        };
    }

    componentDidMount() {
        fetch("https://www.thesportsdb.com/api/v1/json/1/all_sports.php")
            .then(res => res.json())
            .then(
                (result) => {
                    console.log( result );
                    this.setState({
                        isLoaded: true,
                        items: this.filterItems(result.sports)
                    });
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            );
    }

    render() {
        const { error, isLoaded, items } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div className={"Header-loading"}>Loading...</div>;
        } else {
            return (
                <div className="App">
                    <header className="App-header">
                        Sports
                    </header>
                </div>
            );
        }
    }
}

export default HeaderComponent;
