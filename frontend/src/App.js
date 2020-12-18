import React from 'react';
import Home from './Home.js';
import Top from './Top.js'

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";

function App() {
    return (
        <Router>
            <div>
                <nav>
                    <ul>
                        <li>
                            <Link to="/">
                                <button type="button">
                                    Solve
                                </button>
                            </Link>
                        </li>
                        <li>
                            <Link to="/top">
                                <button type="button">
                                    Top 3
                                </button>
                            </Link>
                        </li>
                    </ul>
                </nav>

                {/* A <Switch> looks through its children <Route>s and
                    renders the first one that matches the current URL. */}
                <Switch>
                    <Route path="/top">
                        <Top />
                    </Route>
                    <Route path="/">
                        <Home />
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}

export default App;
