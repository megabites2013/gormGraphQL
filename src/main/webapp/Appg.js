import React, {Component} from 'react';
import {Grid} from 'react-bootstrap';
import SpeakerList from "./SpeakerList";

class Appg extends Component {


    render() {

        return (
            <Grid>
                <h1>Speaker List</h1>
                <SpeakerList/>
            </Grid>
        );
    }
}

export default Appg;