var path = require('path');

module.exports = {
  mode: 'development',
  entry: './src/index.ts',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'main.js'
  },
  module: {
    rules: [{
        use: 'ts-loader',
        exclude: /node_modules/
    }]
  },
  resolve: {
      extensions: [ '.ts', '.js' ]
  }
};