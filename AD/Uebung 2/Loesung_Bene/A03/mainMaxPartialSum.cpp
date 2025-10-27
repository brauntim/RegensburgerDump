#include <iostream>
#include <limits>

int main(int argc, char** argv) {
    if (argc < 3) {
        std::cout << "please input height and width of the matrix via commandline" << std::endl;
        return -1;
    }

    int height;
    int width;
    try {
        height = std::stoi(std::string(argv[1]));
        width  = std::stoi(std::string(argv[2]));
    } catch (...) {
        std::cout << "invalid arguments for width and height" << std::endl;
        return -1;
    }

    int input[height][width];

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            std::cout << "Enter input for cell (" << i << "|" << j << "): ";
            while(true) {
                std::cin >> input[i][j];
                if (!std::cin.fail()) 
                    break;
                std::cin.clear(); 
                std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
            }

        }
    }

    int prefix[height][width];

    //Time Complexity: O(height*width)
    for (int i = 0; i < height; i++) { 
        for (int j = 0; j < width; j++) {
            prefix[i][j] = input[i][j];
            if (i > 0)          prefix[i][j] += prefix[i-1][j];
            if (j > 0)          prefix[i][j] += prefix[i][j-1];
            if (i > 0 && j > 0) prefix[i][j] -= prefix[i-1][j-1];
        }
    }

    int max = std::numeric_limits<int>::min();

    //Time Complexity: O(height*width*height*width) 
    for (int i1 = 0; i1 < height; i1++) {
        for (int j1 = 0; j1 < width; j1++) {
            for (int i2 = i1; i2 < height; i2++) {
                for (int j2 = j1; j2 < width; j2++) {
                    int tmpVal = prefix[i2][j2];
                    if (i1 > 0)       tmpVal -= prefix[i1 - 1][j2];
                    if (j1 > 0)       tmpVal -= prefix[i2][j1 - 1];
                    if (i1 > 0 && j1 > 0) tmpVal += prefix[i1 - 1][j1 - 1];

                    if (tmpVal > max)
                        max = tmpVal;
                }
            }
        }
    }

    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) 
            std::cout << input[i][j]<<"\t";
        std::cout << std::endl;
    }

    std::cout << max << std::endl;
}

//over all Time Complexity: O(height*width*height*width + height*width + height*width) =>  O(height*width*height*width)
