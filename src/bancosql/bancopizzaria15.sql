/*
SQLyog Ultimate v9.51 
MySQL - 5.6.26-log : Database - pizzaria15
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pizzaria15` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pizzaria15`;

/*Table structure for table `categoriaproduto` */

DROP TABLE IF EXISTS `categoriaproduto`;

CREATE TABLE `categoriaproduto` (
  `categoria` varchar(20) NOT NULL,
  PRIMARY KEY (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `categoriaproduto` */

insert  into `categoriaproduto`(`categoria`) values ('Broto'),('Espiha'),('Pizza'),('Queijo'),('Refrigerante');

/*Table structure for table `clientes` */

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `telefone` varchar(13) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `numero` varchar(6) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `clientes` */

insert  into `clientes`(`telefone`,`nome`,`cep`,`endereco`,`numero`,`complemento`,`cidade`,`uf`,`bairro`) values ('25858180','Paulo','08080300','FIGUEIREDO PIMENTEL','10','Proximo ao nagumo','SAO PAULO','SP','PARQUE PAULISTANO');

/*Table structure for table `compras` */

DROP TABLE IF EXISTS `compras`;

CREATE TABLE `compras` (
  `NPedido` int(10) NOT NULL AUTO_INCREMENT,
  `nomeFantasia` varchar(50) DEFAULT NULL,
  `cpfFor` varchar(14) DEFAULT NULL,
  `cnpjFor` varchar(18) DEFAULT NULL,
  `formapagto` varchar(18) DEFAULT NULL,
  `condicaopagto` varchar(9) DEFAULT NULL,
  `parcelas` int(1) DEFAULT NULL,
  `tipopedido` varchar(7) DEFAULT NULL,
  `valortotal` float(5,2) DEFAULT NULL,
  `valordesc` float(5,2) DEFAULT NULL,
  `valornf` float(5,2) DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `tipoproduto` varchar(30) DEFAULT NULL,
  `produto` varchar(50) DEFAULT NULL,
  `unidmedida` varchar(2) DEFAULT NULL,
  `refproduto` varchar(20) DEFAULT NULL,
  `qtde` int(7) DEFAULT NULL,
  `valorunit` float(5,2) DEFAULT NULL,
  `valordescitens` float(5,2) DEFAULT NULL,
  `valornfitens` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`NPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `compras` */

insert  into `compras`(`NPedido`,`nomeFantasia`,`cpfFor`,`cnpjFor`,`formapagto`,`condicaopagto`,`parcelas`,`tipopedido`,`valortotal`,`valordesc`,`valornf`,`observacao`,`tipoproduto`,`produto`,`unidmedida`,`refproduto`,`qtde`,`valorunit`,`valordescitens`,`valornfitens`) values (10,'Atacadao','455.365.058-40','38.362.852/0001-00','Cartão de Crédito','Parcelado',6,'Pedido',4.00,5.00,45.00,'4554','Refrigerante','Refrigerante 300ML','UN','5',4,5.00,4.00,5.00),(17,'Atacadao','455.365.058-40','38.362.852/0001-00','Cartão de Crédito','Parcelado',6,'Pedido',4.00,5.00,45.00,'4554','Refrigerante','Refrigerante 300ML','UN','5',4,5.00,4.00,5.00),(19,'Atacadao','455.365.058-40','38.362.852/0001-00','Cartão de Crédito','Parcelado',6,'Pedido',4.00,5.00,45.00,'4554','Refrigerante','Refrigerante 300ML','UN','5',4,5.00,4.00,5.00);

/*Table structure for table `contaspagar` */

DROP TABLE IF EXISTS `contaspagar`;

CREATE TABLE `contaspagar` (
  `notaFiscal` varchar(100) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `dataRecebimento` varchar(10) DEFAULT NULL,
  `dataEmissao` varchar(10) DEFAULT NULL,
  `dataVencimento` varchar(10) DEFAULT NULL,
  `valor` varchar(10) DEFAULT NULL,
  `juros` varchar(10) DEFAULT NULL,
  `multa` varchar(10) DEFAULT NULL,
  `fornecedor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`notaFiscal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contaspagar` */

insert  into `contaspagar`(`notaFiscal`,`descricao`,`dataRecebimento`,`dataEmissao`,`dataVencimento`,`valor`,`juros`,`multa`,`fornecedor`) values ('121','conta de agua','12/12/1212','12/12/1212','12/12/1212','34,00','43,00','3,00','Paulo'),('42442','conta de luz','12/12/1212','12/12/1212','12/12/1212','34,00','43,00','3,00','Paulo');

/*Table structure for table `contasreceber` */

DROP TABLE IF EXISTS `contasreceber`;

CREATE TABLE `contasreceber` (
  `telefone` varchar(13) DEFAULT NULL,
  `Cliente` varchar(50) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `valor` varchar(10) DEFAULT NULL,
  `juros` varchar(10) DEFAULT NULL,
  `multa` varchar(10) DEFAULT NULL,
  `tipopagamento` varchar(20) DEFAULT NULL,
  `nparcela` varchar(1) DEFAULT NULL,
  `dtrecebimento` varchar(10) DEFAULT NULL,
  `dtemissao` varchar(10) DEFAULT NULL,
  `dtvencimento` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contasreceber` */

insert  into `contasreceber`(`telefone`,`Cliente`,`descricao`,`valor`,`juros`,`multa`,`tipopagamento`,`nparcela`,`dtrecebimento`,`dtemissao`,`dtvencimento`) values ('545','6565','7876','78,00','7,00','7,00','Cartão de Débito','1','56/54/6546','45/65/4654','56/65/6546'),('11343485','Paulo','Conta','4,00','3,00','2,00','Cartão de Débito','1','23/42/4324','34/23/4234','34/23/4234');

/*Table structure for table `fornecedor` */

DROP TABLE IF EXISTS `fornecedor`;

CREATE TABLE `fornecedor` (
  `cnpjFor` varchar(20) NOT NULL,
  `cpfFor` varchar(15) DEFAULT NULL,
  `nomeFantasia` varchar(50) DEFAULT NULL,
  `endeFor` varchar(50) DEFAULT NULL,
  `cidadeFor` varchar(30) DEFAULT NULL,
  `nomeContato` varchar(50) DEFAULT NULL,
  `emailFor` varchar(30) DEFAULT NULL,
  `bairroFor` varchar(30) DEFAULT NULL,
  `telFor` varchar(15) DEFAULT NULL,
  `cepFor` varchar(13) DEFAULT NULL,
  `celFor` varchar(14) DEFAULT NULL,
  `estadualFor` varchar(15) DEFAULT NULL,
  `numFor` varchar(6) DEFAULT NULL,
  `tel2For` varchar(15) DEFAULT NULL,
  `siteFor` varchar(40) DEFAULT NULL,
  `tipopessoa` varchar(17) DEFAULT NULL,
  `ufFor` varchar(2) DEFAULT NULL,
  `tipoproduto` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`cnpjFor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fornecedor` */

insert  into `fornecedor`(`cnpjFor`,`cpfFor`,`nomeFantasia`,`endeFor`,`cidadeFor`,`nomeContato`,`emailFor`,`bairroFor`,`telFor`,`cepFor`,`celFor`,`estadualFor`,`numFor`,`tel2For`,`siteFor`,`tipopessoa`,`ufFor`,`tipoproduto`) values ('  .   .   /    -  ','455.365.058-40','Extra','SUACUAPARA','SAO PAULO','Paulo','a@a.com','PARQUE PAULISTANO','(42)3424-3242','08080100','(34)23525-4525','   .   .   .   ','43','(23)1231-2423','a.com.br','Pessoa Fisica','SP','Pizza'),('38.362.852/0001-00','   .   .   -  ','Atacadao','SUACUAPARA','SAO PAULO','Paulo','a@a.com','PARQUE PAULISTANO','(42)3424-3242','08080100','(34)23525-4525','454.545.435.524','43','(23)1231-2423','a.com.br','Pessoa Juridica','SP','Refrigerante');

/*Table structure for table `funcionario` */

DROP TABLE IF EXISTS `funcionario`;

CREATE TABLE `funcionario` (
  `nomeFun` varchar(50) DEFAULT NULL,
  `rgFun` varchar(15) DEFAULT NULL,
  `cpfFun` varchar(15) NOT NULL,
  `nasciFun` varchar(10) DEFAULT NULL,
  `endeFun` varchar(100) DEFAULT NULL,
  `compleFun` varchar(100) DEFAULT NULL,
  `bairroFun` varchar(50) DEFAULT NULL,
  `cidadeFun` varchar(20) DEFAULT NULL,
  `cepFun` varchar(15) DEFAULT NULL,
  `numFun` varchar(5) DEFAULT NULL,
  `telFun` varchar(15) DEFAULT NULL,
  `celFun` varchar(15) DEFAULT NULL,
  `sexoFun` varchar(10) NOT NULL,
  `setorFun` varchar(20) DEFAULT NULL,
  `ufFun` varchar(2) DEFAULT NULL,
  `motoboy` varchar(3) DEFAULT NULL,
  `placamoto` varchar(7) DEFAULT NULL,
  `cnh` varchar(11) DEFAULT NULL,
  `modelomoto` varchar(15) DEFAULT NULL,
  `situacao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cpfFun`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `funcionario` */

insert  into `funcionario`(`nomeFun`,`rgFun`,`cpfFun`,`nasciFun`,`endeFun`,`compleFun`,`bairroFun`,`cidadeFun`,`cepFun`,`numFun`,`telFun`,`celFun`,`sexoFun`,`setorFun`,`ufFun`,`motoboy`,`placamoto`,`cnh`,`modelomoto`,`situacao`) values ('Marcelo','39.725.858-6','057.045.958-39','28/07/2000','SUACUAPARA','','PARQUE PAULISTANO','SAO PAULO','08080100','276','(11)2585-3775','(11)96791-6805','Masculino','caixa','SP','NAO','fd','dfsdfsff','dsfsfdf','Ativado'),('william','39.725.858-6','264.051.848-89','28/07/2000','SUACUAPARA','','PARQUE PAULISTANO','SAO PAULO','08080100','276','(11)2585-3775','(11)96791-6805','Masculino','caixa','SP','SIM','fd','dfsdfsff','dsfsfdf',NULL),('Paulo','48.695.431-6','455.365.058-40','29/01/1995','SUACUAPARA','a','PARQUE PAULISTANO','SAO PAULO','08080100','5','(11)2154-5221','(54)54121-2548','Masculino','caixa','SP','NAO','','','','Ativado');

/*Table structure for table `itenspedido` */

DROP TABLE IF EXISTS `itenspedido`;

CREATE TABLE `itenspedido` (
  `npedido` int(10) DEFAULT NULL,
  `produto` varchar(50) DEFAULT NULL,
  `preco` float(5,2) DEFAULT NULL,
  `qtde` int(3) DEFAULT NULL,
  `total` float(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `itenspedido` */

insert  into `itenspedido`(`npedido`,`produto`,`preco`,`qtde`,`total`) values (6,'Meio a Meio de Pizza mussarela  e Atum',28.00,1,28.00),(6,'Meio a Meio de Pizza mussarela  e Atum',32.00,1,32.00),(8,'Atum',32.00,1,32.00),(13,'Meio a Meio de Pizza Calabresa e Pizza Calabresa',32.00,1,32.00),(14,'Refrigerante 300ML',5.99,1,5.99),(15,'Refrigerante 300ML',5.99,1,5.99),(16,'Pizza Calabresa',25.00,1,25.00),(17,'Meio a Meio de Pizza Calabresa e Pizza Calabresa',0.00,1,25.00),(18,'Pizza mussarela ',28.00,1,28.00),(19,'Pizza Calabresa',25.00,1,25.00),(20,'Meio a Meio de Pizza Calabresa e Pizza Calabresa',0.00,1,25.00),(21,'Pizza Calabresa',25.00,1,25.00),(22,'Meio a Meio de Atum e Pizza Calabresa',32.00,1,32.00),(23,'Meio a Meio de Pizza mussarela  e Pizza Calabresa',28.00,1,28.00),(23,'Atum',32.00,1,32.00),(23,'Refrigerante 300ML',5.99,1,5.99),(24,'Atum',32.00,1,32.00),(24,'Meio a Meio de Pizza Calabresa e Pizza mussarela ',28.00,1,28.00),(25,'Pizza mussarela ',28.00,1,28.00),(26,'Pizza Calabresa',25.00,1,25.00);

/*Table structure for table `produtos` */

DROP TABLE IF EXISTS `produtos`;

CREATE TABLE `produtos` (
  `codigoproduto` varchar(5) NOT NULL,
  `tipoproduto` varchar(20) DEFAULT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `ingredientes` varchar(50) DEFAULT NULL,
  `unidmedida` varchar(2) DEFAULT NULL,
  `estocavel` varchar(3) DEFAULT NULL,
  `qtdeminima` int(6) DEFAULT NULL,
  `acabadoprima` varchar(25) DEFAULT NULL,
  `valor` float(6,2) DEFAULT NULL,
  `qtdeestoque` int(6) DEFAULT NULL,
  `produtovenda` varchar(3) DEFAULT NULL,
  `dataregistro` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigoproduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `produtos` */

insert  into `produtos`(`codigoproduto`,`tipoproduto`,`descricao`,`ingredientes`,`unidmedida`,`estocavel`,`qtdeminima`,`acabadoprima`,`valor`,`qtdeestoque`,`produtovenda`,`dataregistro`) values ('121','Refrigerante','Refrigerante 300ML','','LT','SIM',5,'Produto Acabado',5.99,100,'SIM',NULL),('31','Pizza','Pizza mussarela ','queijo queijo e mais queijo','UN','NAO',0,'Produto Acabado',28.00,0,'SIM',NULL),('34','Pizza','Pizza Calabresa','calabreza , fermento','UN','NAO',0,'Produto Acabado',25.00,0,'SIM',NULL),('75','Pizza','Atum','atum','UN','-',0,'Produto Acabado',32.00,0,'SIM',NULL);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `codigo` int(30) DEFAULT NULL,
  `nome` varchar(60) DEFAULT NULL,
  `login` varchar(40) NOT NULL,
  `senha` varchar(60) DEFAULT NULL,
  `permissao` varchar(4) DEFAULT NULL,
  `logado` char(2) DEFAULT NULL,
  `cpfFun` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`codigo`,`nome`,`login`,`senha`,`permissao`,`logado`,`cpfFun`) values (NULL,NULL,'admin','admin','1','s','057.045.958-39'),(NULL,NULL,'caixa','caixa','0','n','455.365.058-40'),(NULL,NULL,'teste','teste','00','n','563.553.262-43');

/*Table structure for table `venda` */

DROP TABLE IF EXISTS `venda`;

CREATE TABLE `venda` (
  `npedido` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `telefone` varchar(13) DEFAULT NULL,
  `total` float(5,2) DEFAULT NULL,
  `formaPagamento` varchar(20) DEFAULT NULL,
  `observacao` varchar(50) DEFAULT NULL,
  `data` varchar(10) DEFAULT NULL,
  `valorrecebido` float(5,2) DEFAULT NULL,
  `troco` float(5,2) DEFAULT NULL,
  `hora` varchar(8) DEFAULT NULL,
  `tipopedido` varchar(20) DEFAULT NULL,
  `situacaoEntrega` varchar(20) DEFAULT NULL,
  `hrsaida` varchar(8) DEFAULT NULL,
  `horaentrega` varchar(8) DEFAULT NULL,
  `motoboy` varchar(50) DEFAULT NULL,
  `dataformat` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`npedido`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `venda` */

insert  into `venda`(`npedido`,`telefone`,`total`,`formaPagamento`,`observacao`,`data`,`valorrecebido`,`troco`,`hora`,`tipopedido`,`situacaoEntrega`,`hrsaida`,`horaentrega`,`motoboy`,`dataformat`) values (21,'',25.00,'Cartão de Crédito','','29-09-2015',0.00,0.00,'02:46:04','Pedido Entrega',NULL,NULL,NULL,NULL,NULL),(22,'25858180',32.00,'Cartão de Crédito','','29-09-2015',0.00,0.00,'02:46:51','Pedido Entrega','Saiu Para Entregar','12:28:16','','Paulo',NULL),(23,'25853775',65.99,'Dinheiro','calotero','29-09-2015',100.00,34.01,'03:15:56','Pedido Entrega','Não Entregue','12:33:02','12:33:05','william',NULL),(24,'25858180',60.00,'Dinheiro','','29-09-2015',100.00,40.00,'03:56:15','Pedido Entrega','Não Entregue','12:43:26','12:43:24','Paulo',NULL),(25,'',28.00,'Cartão de Crédito','','27/10/2015',0.00,0.00,'08:18:55','Pedido Balcao','Aberto',NULL,NULL,NULL,'2015/10/27'),(26,'',25.00,'Cartão de Crédito','','27/10/2015',0.00,0.00,'08:56:13','Pedido Balcao','Aberto',NULL,NULL,NULL,'2015/10/27');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
