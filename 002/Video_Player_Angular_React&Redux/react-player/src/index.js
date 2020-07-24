import React from 'react';
import ReactDOM from 'react-dom';

import VideoPlay from './components/videoplay';
import AddNewVideo from './components/addnewvideo';

class Video extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dataList: null
        };
    }
    render() {
        return (
            <div>
                <VideoPlay dataList={this.state.dataList}/>
                <br></br>
                <AddNewVideo dataList={() => this.dataList()}/>
            </div>
        );
    }

    dataList(){
        this.setState({dataList:'dataList'});
    }
}


ReactDOM.render(
    <Video />,
    document.getElementById('root')
);
