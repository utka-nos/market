const path = require("path")

module.exports = {
    entry: "./src/index.js",
    mode: "development",
    cache: true,
    output: {
        path: path.resolve(__dirname, "./dist"),
        filename: "bundle.js"
    },

    devServer: {
        compress: true,
        port: 9000,
        static: {
            directory: path.resolve(__dirname, './public')
        },
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
            "Access-Control-Allow-Headers": "X-Requested-With, content-type, Authorization"
        },
        allowedHosts : [
            'localhost:8080',
            'http://localhost:8080',
        ]
    },

    plugins: [

    ],

    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /(node_modules|bower_components)/,
                use: [
                    {
                        loader: "babel-loader",
                        options: {
                            presets: [
                                '@babel/preset-env',
                                '@babel/preset-react'
                            ]
                        }
                    }
                ]
            },
            {
                test: /\.css$/,
                use: [
                    "style-loader",
                    {
                        loader: "css-loader",
                        options: {

                        }
                    },
                    /*{
                        loader: "postcss-loader",
                        options: {
                            postcssOptions: {
                                plugins: function () {
                                    return [
                                        require('autoprefixer')
                                    ]
                                }
                            }
                        }
                    },*/
                    // Для подкгрузки css файлов в импортах реакт компонентов
                    {
                        loader: "sass-loader"
                    }
                ]
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: ["file-loader"]
            }
        ]
    }
}