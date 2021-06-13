package game;

public class Player implements PlayerInterface {
    private double posX;
    private double posY;
    private int velocityX;
    private int velocityY;
    private double startPosX;
    private double startPosY;
    private int size;
    private boolean alive = true;
    private boolean winner = false;
    private int score = 0;

    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    Player(double posX, double posY, int size){
        this.posX = posX;
        this.posY = posY;
        this.startPosX = posX;
        this.startPosY = posY;
        this.size = size;
    }
    public double getPosX()
    {
        return this.posX;
    }
    public double getPosY()
    {
        return this.posY;
    }
    public void StartMove()
    {
        this.posX+=this.velocityX*this.size;
        this.posY+=this.velocityY*this.size;
    }
    public void StopMove()
    {
        this.movingLeft = false;
        this.movingRight = false;
        this.movingUp = false;
        this.movingDown = false;
    }
    public void ResetPlayer()
    {
        this.posX = this.startPosX;
        this.posY = this.startPosY;
        this.alive = true;
        this.winner = false;
        this.StopMove();
    }
    public void MoveDOWN()
    {
        if(!movingUp)
        {
            this.velocityX = 0;
            this.velocityY = 1;
            this.movingDown = true;
            this.movingLeft = false;
            this.movingRight = false;
        }
    }
    public void MoveUP()
    {
        if(!movingDown)
        {
            this.velocityX = 0;
            this.velocityY = -1;
            this.movingUp = true;
            this.movingLeft = false;
            this.movingRight = false;
        }
    }
    public void MoveLEFT()
    {
        if(!movingRight)
        {
            this.velocityX = -1;
            this.velocityY = 0;
            this.movingUp = false;
            this.movingLeft = true;
            this.movingDown = false;
        }
    }
    public void MoveRIGHT()
    {
        if(!movingLeft)
        {
            this.velocityX = 1;
            this.velocityY = 0;
            this.movingUp = false;
            this.movingDown = false;
            this.movingRight = true;
        }
    }
    public void PlayerCollision()
    {
        this.alive = false;
    }
    public void ResetScore()
    {
        this.score = 0;
    }
    public void AddWin(){
        this.winner = true;
        this.score++;
    }


    @Override
    public boolean getWinner() {
        return this.winner;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    public boolean IsInBounds(double height, double width) {
        if (((this.posX >= 0) && (this.posX) < width) && ((this.posY >= 0) && (this.posY < height))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsAlive() {
        return this.alive;
    }
}
