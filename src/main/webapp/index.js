import React from 'react';
import ReactDOM from 'react-dom';
import Appg from './Appg';
import './css/App.css';
import './css/grails.css';
import './css/main.css';
import {ApolloProvider} from 'react-apollo';
import {ApolloClient} from 'apollo-client';
import {HttpLink} from 'apollo-link-http';
import {InMemoryCache} from 'apollo-cache-inmemory';

const client = new ApolloClient({
    link: new HttpLink(),
    cache: new InMemoryCache()
});


ReactDOM.render(
    <ApolloProvider client={client}>
        <Appg/>
    </ApolloProvider>,
    document.getElementById('root')
);