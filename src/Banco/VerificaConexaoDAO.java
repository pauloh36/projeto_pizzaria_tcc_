/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Banco.ConnectionFactory;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificaConexaoDAO {

    static Connection connection;
    ConnectionFactory connectionFactory = new ConnectionFactory();

    public boolean VerificaConexao(String newServer, String newPorta, String newSenha) {
        connection = connectionFactory.getConnection(newServer, newPorta, newSenha);
        try {
            if (connection.isValid(1)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerificaConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean criaBancoDeDados(String nameDataBase) {
        try {
            Statement statement = connection.createStatement();
            if (!statement.execute("CREATE DATABASE IF NOT EXISTS " + nameDataBase)) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VerificaConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean criaTabelas(String dataBase) {
        try {
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE `" + dataBase + "`.`categoriaproduto` (\n"
                    + "  `categoria` varchar(20) NOT NULL,\n"
                    + "  PRIMARY KEY (`categoria`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`clientes` (\n"
                    + "  `telefone` varchar(13) NOT NULL,\n"
                    + "  `nome` varchar(50) DEFAULT NULL,\n"
                    + "  `cep` varchar(10) DEFAULT NULL,\n"
                    + "  `endereco` varchar(50) DEFAULT NULL,\n"
                    + "  `numero` varchar(6) DEFAULT NULL,\n"
                    + "  `complemento` varchar(200) DEFAULT NULL,\n"
                    + "  `cidade` varchar(50) DEFAULT NULL,\n"
                    + "  `uf` varchar(2) DEFAULT NULL,\n"
                    + "  `bairro` varchar(50) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`telefone`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`compras` (\n"
                    + "  `NPedido` int(10) NOT NULL AUTO_INCREMENT,\n"
                    + "  `nomeFantasia` varchar(50) DEFAULT NULL,\n"
                    + "  `cpfFor` varchar(14) DEFAULT NULL,\n"
                    + "  `cnpjFor` varchar(18) DEFAULT NULL,\n"
                    + "  `formapagto` varchar(18) DEFAULT NULL,\n"
                    + "  `condicaopagto` varchar(9) DEFAULT NULL,\n"
                    + "  `parcelas` int(1) DEFAULT NULL,\n"
                    + "  `tipopedido` varchar(7) DEFAULT NULL,\n"
                    + "  `valortotal` float(5,2) DEFAULT NULL,\n"
                    + "  `valordesc` float(5,2) DEFAULT NULL,\n"
                    + "  `valornf` float(5,2) DEFAULT NULL,\n"
                    + "  `observacao` varchar(200) DEFAULT NULL,\n"
                    + "  `tipoproduto` varchar(30) DEFAULT NULL,\n"
                    + "  `produto` varchar(50) DEFAULT NULL,\n"
                    + "  `unidmedida` varchar(2) DEFAULT NULL,\n"
                    + "  `refproduto` varchar(20) DEFAULT NULL,\n"
                    + "  `qtde` int(7) DEFAULT NULL,\n"
                    + "  `valorunit` float(5,2) DEFAULT NULL,\n"
                    + "  `valordescitens` float(5,2) DEFAULT NULL,\n"
                    + "  `valornfitens` float(5,2) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`NPedido`)\n"
                    + ") ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`contaspagar` (\n"
                    + "  `notaFiscal` varchar(100) NOT NULL,\n"
                    + "  `descricao` varchar(200) DEFAULT NULL,\n"
                    + "  `dataRecebimento` varchar(10) DEFAULT NULL,\n"
                    + "  `dataEmissao` varchar(10) DEFAULT NULL,\n"
                    + "  `dataVencimento` varchar(10) DEFAULT NULL,\n"
                    + "  `valor` varchar(10) DEFAULT NULL,\n"
                    + "  `juros` varchar(10) DEFAULT NULL,\n"
                    + "  `multa` varchar(10) DEFAULT NULL,\n"
                    + "  `fornecedor` varchar(50) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`notaFiscal`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`contasreceber` (\n"
                    + "  `telefone` varchar(13) DEFAULT NULL,\n"
                    + "  `Cliente` varchar(50) DEFAULT NULL,\n"
                    + "  `descricao` varchar(200) DEFAULT NULL,\n"
                    + "  `valor` varchar(10) DEFAULT NULL,\n"
                    + "  `juros` varchar(10) DEFAULT NULL,\n"
                    + "  `multa` varchar(10) DEFAULT NULL,\n"
                    + "  `tipopagamento` varchar(20) DEFAULT NULL,\n"
                    + "  `nparcela` varchar(1) DEFAULT NULL,\n"
                    + "  `dtrecebimento` varchar(10) DEFAULT NULL,\n"
                    + "  `dtemissao` varchar(10) DEFAULT NULL,\n"
                    + "  `dtvencimento` varchar(10) DEFAULT NULL\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`fornecedor` (\n"
                    + "  `cnpjFor` varchar(20) NOT NULL,\n"
                    + "  `cpfFor` varchar(15) DEFAULT NULL,\n"
                    + "  `nomeFantasia` varchar(50) DEFAULT NULL,\n"
                    + "  `endeFor` varchar(50) DEFAULT NULL,\n"
                    + "  `cidadeFor` varchar(30) DEFAULT NULL,\n"
                    + "  `nomeContato` varchar(50) DEFAULT NULL,\n"
                    + "  `emailFor` varchar(30) DEFAULT NULL,\n"
                    + "  `bairroFor` varchar(30) DEFAULT NULL,\n"
                    + "  `telFor` varchar(15) DEFAULT NULL,\n"
                    + "  `cepFor` varchar(13) DEFAULT NULL,\n"
                    + "  `celFor` varchar(14) DEFAULT NULL,\n"
                    + "  `estadualFor` varchar(15) DEFAULT NULL,\n"
                    + "  `numFor` varchar(6) DEFAULT NULL,\n"
                    + "  `tel2For` varchar(15) DEFAULT NULL,\n"
                    + "  `siteFor` varchar(40) DEFAULT NULL,\n"
                    + "  `tipopessoa` varchar(17) DEFAULT NULL,\n"
                    + "  `ufFor` varchar(2) DEFAULT NULL,\n"
                    + "  `tipoproduto` varchar(25) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`cnpjFor`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`funcionario` (\n" +
"  `nomeFun` varchar(50) DEFAULT NULL,\n" +
"  `rgFun` varchar(15) DEFAULT NULL,\n" +
"  `cpfFun` varchar(15) NOT NULL,\n" +
"  `nasciFun` varchar(10) DEFAULT NULL,\n" +
"  `endeFun` varchar(100) DEFAULT NULL,\n" +
"  `compleFun` varchar(100) DEFAULT NULL,\n" +
"  `bairroFun` varchar(50) DEFAULT NULL,\n" +
"  `cidadeFun` varchar(20) DEFAULT NULL,\n" +
"  `cepFun` varchar(15) DEFAULT NULL,\n" +
"  `numFun` varchar(5) DEFAULT NULL,\n" +
"  `telFun` varchar(15) DEFAULT NULL,\n" +
"  `celFun` varchar(15) DEFAULT NULL,\n" +
"  `sexoFun` varchar(10) NOT NULL,\n" +
"  `setorFun` varchar(20) DEFAULT NULL,\n" +
"  `ufFun` varchar(2) DEFAULT NULL,\n" +
"  `motoboy` varchar(3) DEFAULT NULL,\n" +
"  `placamoto` varchar(7) DEFAULT NULL,\n" +
"  `cnh` varchar(11) DEFAULT NULL,\n" +
"  `modelomoto` varchar(15) DEFAULT NULL,\n" +
"  `situacao` varchar(10) DEFAULT NULL,\n" +
"  PRIMARY KEY (`cpfFun`)\n" +
") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`itenspedido` (\n"
                    + "  `npedido` int(10) DEFAULT NULL,\n"
                    + "  `produto` varchar(50) DEFAULT NULL,\n"
                    + "  `preco` float(5,2) DEFAULT NULL,\n"
                    + "  `qtde` int(3) DEFAULT NULL,\n"
                    + "  `total` float(5,2) DEFAULT NULL\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`produtos` (\n"
                    + "  `codigoproduto` varchar(5) NOT NULL,\n"
                    + "  `tipoproduto` varchar(20) DEFAULT NULL,\n"
                    + "  `descricao` varchar(50) DEFAULT NULL,\n"
                    + "  `ingredientes` varchar(50) DEFAULT NULL,\n"
                    + "  `unidmedida` varchar(2) DEFAULT NULL,\n"
                    + "  `estocavel` varchar(3) DEFAULT NULL,\n"
                    + "  `qtdeminima` int(6) DEFAULT NULL,\n"
                    + "  `acabadoprima` varchar(25) DEFAULT NULL,\n"
                    + "  `valor` float(6,2) DEFAULT NULL,\n"
                    + "  `qtdeestoque` int(6) DEFAULT NULL,\n"
                    + "  `produtovenda` varchar(3) DEFAULT NULL,\n"
                    + "  `dataregistro` varchar(10) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`codigoproduto`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`usuario` (\n"
                    + "  `codigo` int(30) DEFAULT NULL,\n"
                    + "  `nome` varchar(60) DEFAULT NULL,\n"
                    + "  `login` varchar(40) NOT NULL,\n"
                    + "  `senha` varchar(60) DEFAULT NULL,\n"
                    + "  `permissao` varchar(4) DEFAULT NULL,\n"
                    + "  `logado` char(2) DEFAULT NULL,\n"
                    + "  `cpfFun` varchar(15) DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`login`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            statement.execute("CREATE TABLE `" + dataBase + "`.`venda` (`npedido` int(10) unsigned NOT NULL AUTO_INCREMENT,\n" +
"  `telefone` varchar(13) DEFAULT NULL,\n" +
"  `total` float(5,2) DEFAULT NULL,\n" +
"  `formaPagamento` varchar(20) DEFAULT NULL,\n" +
"  `observacao` varchar(50) DEFAULT NULL,\n" +
"  `data` varchar(10) DEFAULT NULL,\n" +
"  `valorrecebido` float(5,2) DEFAULT NULL,\n" +
"  `troco` float(5,2) DEFAULT NULL,\n" +
"  `hora` varchar(8) DEFAULT NULL,\n" +
"  `tipopedido` varchar(20) DEFAULT NULL,\n" +
"  `situacaoEntrega` varchar(20) DEFAULT NULL,\n" +
"  `hrsaida` varchar(8) DEFAULT NULL,\n" +
"  `horaentrega` varchar(8) DEFAULT NULL,\n" +
"  `motoboy` varchar(50) DEFAULT NULL,\n" +
"  `dataformat` varchar(10) DEFAULT NULL,\n" +
"  PRIMARY KEY (`npedido`)\n" +
") ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;");

            statement.execute("insert  into `" + dataBase + "`.`categoriaproduto`(`categoria`) values ('Broto'),('Espiha'),('Pizza'),('Queijo'),('Refrigerante');");
            statement.execute("insert into `" + dataBase + "`.`clientes`(`telefone`,`nome`,`cep`,`endereco`,`numero`,`complemento`,`cidade`,`uf`,`bairro`) values ('25858180','Paulo','08080300','FIGUEIREDO PIMENTEL','10','Proximo ao nagumo','SAO PAULO','SP','PARQUE PAULISTANO');");
            statement.execute("insert into " + dataBase + ".`compras`(`NPedido`,`nomeFantasia`,`cpfFor`,`cnpjFor`,`formapagto`,`condicaopagto`,`parcelas`,`tipopedido`,`valortotal`,`valordesc`,`valornf`,`observacao`,`tipoproduto`,`produto`,`unidmedida`,`refproduto`,`qtde`,`valorunit`,`valordescitens`,`valornfitens`) values (10,'Atacadao','455.365.058-40','38.362.852/0001-00','Cartão de Crédito','Parcelado',6,'Pedido',4.00,5.00,45.00,'4554','Refrigerante','Refrigerante 300ML','UN','5',4,5.00,4.00,5.00),(17,'Atacadao','455.365.058-40','38.362.852/0001-00','Cartão de Crédito','Parcelado',6,'Pedido',4.00,5.00,45.00,'4554','Refrigerante','Refrigerante 300ML','UN','5',4,5.00,4.00,5.00),(19,'Atacadao','455.365.058-40','38.362.852/0001-00','Cartão de Crédito','Parcelado',6,'Pedido',4.00,5.00,45.00,'4554','Refrigerante','Refrigerante 300ML','UN','5',4,5.00,4.00,5.00);");
            statement.execute("insert into " + dataBase + ".`contaspagar`(`notaFiscal`,`descricao`,`dataRecebimento`,`dataEmissao`,`dataVencimento`,`valor`,`juros`,`multa`,`fornecedor`) values ('121','conta de agua','12/12/1212','12/12/1212','12/12/1212','34,00','43,00','3,00','Paulo'),('42442','conta de luz','12/12/1212','12/12/1212','12/12/1212','34,00','43,00','3,00','Paulo');");
            statement.execute("insert into " + dataBase + ".`contasreceber`(`telefone`,`Cliente`,`descricao`,`valor`,`juros`,`multa`,`tipopagamento`,`nparcela`,`dtrecebimento`,`dtemissao`,`dtvencimento`) values ('545','6565','7876','78,00','7,00','7,00','Cartão de Débito','1','56/54/6546','45/65/4654','56/65/6546'),('11343485','Paulo','Conta','4,00','3,00','2,00','Cartão de Débito','1','23/42/4324','34/23/4234','34/23/4234');");
            statement.execute("insert into " + dataBase + ".`fornecedor`(`cnpjFor`,`cpfFor`,`nomeFantasia`,`endeFor`,`cidadeFor`,`nomeContato`,`emailFor`,`bairroFor`,`telFor`,`cepFor`,`celFor`,`estadualFor`,`numFor`,`tel2For`,`siteFor`,`tipopessoa`,`ufFor`,`tipoproduto`) values ('  .   .   /    -  ','455.365.058-40','Extra','SUACUAPARA','SAO PAULO','Paulo','a@a.com','PARQUE PAULISTANO','(42)3424-3242','08080100','(34)23525-4525','   .   .   .   ','43','(23)1231-2423','a.com.br','Pessoa Fisica','SP','Pizza'),('38.362.852/0001-00','   .   .   -  ','Atacadao','SUACUAPARA','SAO PAULO','Paulo','a@a.com','PARQUE PAULISTANO','(42)3424-3242','08080100','(34)23525-4525','454.545.435.524','43','(23)1231-2423','a.com.br','Pessoa Juridica','SP','Refrigerante');");
            statement.execute("insert into " + dataBase + ".`funcionario`(`nomeFun`,`rgFun`,`cpfFun`,`nasciFun`,`endeFun`,`compleFun`,`bairroFun`,`cidadeFun`,`cepFun`,`numFun`,`telFun`,`celFun`,`sexoFun`,`setorFun`,`ufFun`,`motoboy`,`placamoto`,`cnh`,`modelomoto`,`situacao`) values ('Marcelo','39.725.858-6','057.045.958-39','28/07/2000','SUACUAPARA','','PARQUE PAULISTANO','SAO PAULO','08080100','276','(11)2585-3775','(11)96791-6805','Masculino','caixa','SP','NAO','fd','dfsdfsff','dsfsfdf','Ativado'),('william','39.725.858-6','264.051.848-89','28/07/2000','SUACUAPARA','','PARQUE PAULISTANO','SAO PAULO','08080100','276','(11)2585-3775','(11)96791-6805','Masculino','caixa','SP','SIM','fd','dfsdfsff','dsfsfdf',NULL),('Paulo','48.695.431-6','455.365.058-40','29/01/1995','SUACUAPARA','a','PARQUE PAULISTANO','SAO PAULO','08080100','5','(11)2154-5221','(54)54121-2548','Masculino','caixa','SP','NAO','','','','Ativado');");
            statement.execute("insert into " + dataBase + ".`itenspedido`(`npedido`,`produto`,`preco`,`qtde`,`total`) values (6,'Meio a Meio de Pizza mussarela  e Atum',28.00,1,28.00),(6,'Meio a Meio de Pizza mussarela  e Atum',32.00,1,32.00),(8,'Atum',32.00,1,32.00),(13,'Meio a Meio de Pizza Calabresa e Pizza Calabresa',32.00,1,32.00),(14,'Refrigerante 300ML',5.99,1,5.99),(15,'Refrigerante 300ML',5.99,1,5.99),(16,'Pizza Calabresa',25.00,1,25.00),(17,'Meio a Meio de Pizza Calabresa e Pizza Calabresa',0.00,1,25.00),(18,'Pizza mussarela ',28.00,1,28.00),(19,'Pizza Calabresa',25.00,1,25.00),(20,'Meio a Meio de Pizza Calabresa e Pizza Calabresa',0.00,1,25.00),(21,'Pizza Calabresa',25.00,1,25.00),(22,'Meio a Meio de Atum e Pizza Calabresa',32.00,1,32.00),(23,'Meio a Meio de Pizza mussarela  e Pizza Calabresa',28.00,1,28.00),(23,'Atum',32.00,1,32.00),(23,'Refrigerante 300ML',5.99,1,5.99),(24,'Atum',32.00,1,32.00),(24,'Meio a Meio de Pizza Calabresa e Pizza mussarela ',28.00,1,28.00),(25,'Pizza mussarela ',28.00,1,28.00),(26,'Pizza Calabresa',25.00,1,25.00);");
            statement.execute("insert into " + dataBase + ".`produtos`(`codigoproduto`,`tipoproduto`,`descricao`,`ingredientes`,`unidmedida`,`estocavel`,`qtdeminima`,`acabadoprima`,`valor`,`qtdeestoque`,`produtovenda`,`dataregistro`) values ('121','Refrigerante','Refrigerante 300ML','','LT','SIM',5,'Produto Acabado',5.99,100,'SIM',NULL),('31','Pizza','Pizza mussarela ','queijo queijo e mais queijo','UN','NAO',0,'Produto Acabado',28.00,0,'SIM',NULL),('34','Pizza','Pizza Calabresa','calabreza , fermento','UN','NAO',0,'Produto Acabado',25.00,0,'SIM',NULL),('75','Pizza','Atum','atum','UN','-',0,'Produto Acabado',32.00,0,'SIM',NULL);");
            statement.execute("insert into " + dataBase + ".`usuario`(`codigo`,`nome`,`login`,`senha`,`permissao`,`logado`,`cpfFun`) values (NULL,NULL,'admin','admin','1',NULL,'057.045.958-39'),(NULL,NULL,'caixa','caixa','0',NULL,'455.365.058-40'),(NULL,NULL,'teste','teste','00','n','563.553.262-43');");
            statement.execute("insert into " + dataBase + ".`venda`(`npedido`,`telefone`,`total`,`formaPagamento`,`observacao`,`data`,`valorrecebido`,`troco`,`hora`,`tipopedido`,`situacaoEntrega`,`hrsaida`,`horaentrega`,`motoboy`,`dataformat`) values (21,'',25.00,'Cartão de Crédito','','29-09-2015',0.00,0.00,'02:46:04','Pedido Entrega',NULL,NULL,NULL,NULL,NULL),(22,'25858180',32.00,'Cartão de Crédito','','29-09-2015',0.00,0.00,'02:46:51','Pedido Entrega','Saiu Para Entregar','12:28:16','','Paulo',NULL),(23,'25853775',65.99,'Dinheiro','calotero','29-09-2015',100.00,34.01,'03:15:56','Pedido Entrega','Não Entregue','12:33:02','12:33:05','william',NULL),(24,'25858180',60.00,'Dinheiro','','29-09-2015',100.00,40.00,'03:56:15','Pedido Entrega','Não Entregue','12:43:26','12:43:24','Paulo',NULL),(25,'',28.00,'Cartão de Crédito','','27/10/2015',0.00,0.00,'08:18:55','Pedido Balcao','Aberto',NULL,NULL,NULL,'2015/10/27'),(26,'',25.00,'Cartão de Crédito','','27/10/2015',0.00,0.00,'08:56:13','Pedido Balcao','Aberto',NULL,NULL,NULL,'2015/10/27');");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(VerificaConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
