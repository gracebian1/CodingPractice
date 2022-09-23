class Solution:
#     Time: O(n^2), Space: O(n^2)

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def isValidRow(board):
            for row in board:
                if not isValid(row):
                    return False
            return True
                
        def isValidCol(board):
            for col in zip(*board):
                if not isValid(col):
                    return False
            return True
        
        def isValidSquare(board):
            for i in (0,3,6):
                for j in (0,3,6):
                    square = [board[x][y] for x in range(i, i+3)
                                          for y in range(j, j+3)]
                    if not isValid(square):
                        return False
            return True
        
        def isValid(value):
            result = [i for i in value if i != '.']
            return len(result) == len(set(result))
        
        return isValidRow(board) and isValidCol(board) and isValidSquare(board) 